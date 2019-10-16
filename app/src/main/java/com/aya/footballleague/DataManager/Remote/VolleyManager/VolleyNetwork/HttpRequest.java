package com.aya.footballleague.DataManager.Remote.VolleyManager.VolleyNetwork;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.aya.footballleague.Constants.AppController;
import com.aya.footballleague.R;
import com.aya.footballleague.utils.NetworkUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by aya mohamed on 11/9/2017.
 */

public abstract class HttpRequest {
    public static final int SOCKET_TIME_OUT = 20000;
    public static final int METHOD_GET = Request.Method.GET;
    public static final int METHOD_POST = Request.Method.POST;
    public static final int METHOD_PUT = Request.Method.PUT;
    public static final int METHOD_DELETE = Request.Method.DELETE;
    public static final int METHOD_PATCH = Request.Method.PATCH;
    public static final int REQUEST_STRING_PARAMS = 0;
    public static final int REQUEST_JSON_PARAMS = 1;

    protected String url;
    protected HttpListener httpListener;
    protected HttpError httpError;
    protected Map<String, String> params;
    protected JSONObject jParams;
    protected HashMap<String, String> headers;
    protected int requestDataType;
    Context context;
    protected int requestMethod;
    protected boolean isShowDialog = true;
    private RetryPolicy policy = null;
    protected Request request;


    public HttpRequest(Context context, int requestDataType, int requestMethod, String url, boolean isShowDialog, HttpListener httpListener,
                       HttpError httpError){
        this.context = context;
        this.httpListener = httpListener;
        this.httpError = httpError;
        this.requestMethod = requestMethod;
        this.requestDataType = requestDataType;
        this.url = url;
        this.isShowDialog = isShowDialog;
        policy = new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 50000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 50000;
            }

            @Override
            public void retry(VolleyError error) throws VolleyError {

            }};

    }

    protected void sendRequest(){
        if (!NetworkUtils.isNetworkConnected(context)) {
            Toast.makeText(context, R.string.connection_failed, Toast.LENGTH_LONG).show();
        } else {
            request.setRetryPolicy(policy);
            AppController.getInstance().addToRequestQueue(request);
        }
    }

    protected void showDialog(){

    }

    protected void closeDialog(){

    }

}
