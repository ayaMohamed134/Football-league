package com.aya.footballleague.data.remote.volleyManager.volleyNetwork;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.aya.footballleague.constants.AppController;

import org.json.JSONObject;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by aya mohamed on 17/4/2018.
 */

public class HttpPost extends HttpRequest {

    private Map<String, File> files;

    public HttpPost(Context context, String url, Map<String, String> params, boolean isShowDialog, HttpListener httpListener,
                    HttpError httpError, HashMap<String, String> headers) {
        super(context, HttpRequest.REQUEST_JSON_PARAMS, HttpRequest.METHOD_POST, url, isShowDialog, httpListener, httpError);
        this.params = params;
        this.headers = headers;
        sendRequest();
    }

    public HttpPost(Context context, String url, JSONObject params, boolean isShowDialog, HttpListener httpListener,
                    HttpError httpError, HashMap<String, String> headers) {
        super(context, HttpRequest.REQUEST_JSON_PARAMS, HttpRequest.METHOD_POST, url, isShowDialog, httpListener, httpError);
        this.jParams = params;
        this.headers = headers;
        sendRequest();
    }

    public HttpPost(Context context, String url, Map<String, String> params, boolean isShowDialog, HttpListener httpListener,
                    HttpError httpError, HashMap<String, String> headers, Map<String, File> files) {
        super(context, HttpRequest.REQUEST_JSON_PARAMS, HttpRequest.METHOD_POST, url, isShowDialog, httpListener, httpError);
        this.params = params;
        this.headers = headers;
        this.files = files;
        getMultipartRequest();
    }

    protected void sendRequest() {
        if (requestDataType == REQUEST_JSON_PARAMS) {
            request = getJsonObjectRequest();
        } else {
            request = getStringRequest();
        }
        super.sendRequest();
    }

    private Request getJsonObjectRequest() {
        Response.Listener successResponse = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                httpListener.onHttpResponse(String.valueOf(response));
            }
        };
        Response.ErrorListener errorResponse = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                httpError.onHttpError(error);
            }
        };

        JSONObject jsonParams;
        if (params == null){
            jsonParams = this.jParams;
        }else {
            jsonParams = params != null ? new JSONObject(params) : null;
        }
        JsonObjectRequest request = new JsonObjectRequest(requestMethod, url, jsonParams, successResponse, errorResponse) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }

        };
        return request;
    }

    private Request getStringRequest() {

        Response.Listener successResponse = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                httpListener.onHttpResponse(response);

            }
        };
        Response.ErrorListener errorResponse = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                httpError.onHttpError(error);

            }
        };
        StringRequest request = new StringRequest(requestMethod, url, successResponse, errorResponse) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() {
                return headers;
            }

        };
        return request;
    }


    private void getMultipartRequest() {
        Response.Listener successResponse = new Response.Listener<NetworkResponse>() {

            @Override
            public void onResponse(NetworkResponse response) {
                if (isShowDialog)
                    closeDialog();
                try {
                    String json = new String(response.data, "UTF-8");
                    httpListener.onHttpResponse(json);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        };
        Response.ErrorListener errorResponse = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                httpError.onHttpError(error);

            }
        };

        MultipartRequest request = new MultipartRequest(url, successResponse, errorResponse, params, files, headers) {

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() {
                return headers;
            }
        };

        try {
            Log.i("req", request.getBodyContentType()
                    + " " + request.getHeaders());
        } catch (AuthFailureError authFailureError) {
            Log.i("req", "error");
        }
        int socketTimeout = 30000;//30 seconds - change to what you want
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);
        AppController.getInstance().addToRequestQueue(request);
    }

}
