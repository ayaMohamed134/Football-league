package com.aya.footballleague.data.Remote.VolleyManager.VolleyNetwork;

import android.content.Context;
import android.net.Uri;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by aya mohamed on 17/4/2018.
 */

public class HttpGet extends HttpRequest{

    public HttpGet(Context context, String url, Map<String, String> params, boolean isShowDialog, HttpListener httpListener,
                   HttpError httpError, HashMap<String, String> headers) {
        super(context, HttpRequest.REQUEST_JSON_PARAMS, HttpRequest.METHOD_GET, url, isShowDialog, httpListener, httpError);
        this.params = params;
        this.headers = headers;
        this.url = getUrl(url, this.params);
        sendRequest();
    }

    public HttpGet(Context context, String url, JSONObject jParams, boolean isShowDialog, HttpListener httpListener,
                   HttpError httpError, HashMap<String, String> headers) {
        super(context, HttpRequest.REQUEST_JSON_PARAMS, HttpRequest.METHOD_GET, url, isShowDialog, httpListener, httpError);
        this.jParams = jParams;
        this.headers = headers;
        this.url = getUrl(url, this.params);
        sendRequest();
    }


    protected void sendRequest() {
        request = getStringRequest();
        super.sendRequest();
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
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return headers;
            }


        };
        return request;
    }

    protected String getUrl(String url, Map<String, String> params) {
        Uri.Builder builder = Uri.parse(url).buildUpon();
        if (params != null) {
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            int i = 1;
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                builder.appendQueryParameter(entry.getKey(), entry.getValue());
                iterator.remove();
                i++;
            }
        }
        return builder.toString();
    }
}
