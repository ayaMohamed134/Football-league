package com.aya.footballleague.data.remote.volleyManager;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.VolleyError;
import com.aya.footballleague.data.remote.volleyManager.volleyNetwork.HttpError;
import com.aya.footballleague.data.remote.volleyManager.volleyNetwork.HttpGet;
import com.aya.footballleague.data.remote.volleyManager.volleyNetwork.HttpListener;
import com.aya.footballleague.data.remote.volleyManager.volleyNetwork.HttpPost;
import com.aya.footballleague.utils.AppConstants;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by aya mohamed on 17/4/2018.
 * THIS INTER-ACTOR WHERE REQUESTS CREATED
 */
@Singleton
public class VolleyInterActor implements IVolleyInterActor {

    private Context context;
    private static final String TAG = VolleyInterActor.class.getSimpleName();
    private static final String AUTH = "X-Auth-Token";
    private static final String CONTENT_TYPE = "Content-Type";


    @Inject
    public VolleyInterActor(Context context) {
        this.context = context;
    }

    /*
     * this to check url
     * @param url string type
     * @return Url
     */
    private URL createUrl(String urlString) {
        URL mUrl = null;
        try {
            mUrl = new URL(urlString);
        } catch (MalformedURLException e) {
            Log.e(TAG, "RootError with creating URL ", e);
            return null;
        }
        return mUrl;
    }

    /*
     * @param requestUrl string type
     * @param HttpUrlConnectionMethod string type
     * @param Map Map<String , String> type and this is params send with request as a request body
     * @param callback is VolleyCallback interface this is used to call onSuccess , onCodeError, onVolleyError
     * @param isShowDialog boolean type this use to show load view while request progress or not
     * @param header Map<String , String> type and this is header send with request as a request header
     * @return void this function initiate volley request
     */
    private void makeHttpRequest(final URL url, final String HttpUrlConnectionMethod, final Map<String, String> mMap
            , final VolleyCallback callback, final boolean isShowDialog, final HashMap<String, String> header) throws IOException, AuthFailureError {

        HttpListener response = new HttpListener() {
            @Override
            public void onHttpResponse(String response) {
                Log.i(TAG, response);
                if (response != null) {
                    callback.onSuccess(response);
                } else {
                    callback.onError(null);
                }
            }
        };

        HttpError errorResponse = new HttpError() {
            @Override
            public void onHttpError(VolleyError volleyError) {
                callback.onError(volleyError);
            }
        };

        if (HttpUrlConnectionMethod.equals(AppConstants.GET_METHOD)) {

            new HttpGet(context, url.toString(), mMap, isShowDialog, response, errorResponse, header);

        } else if (HttpUrlConnectionMethod.equals(AppConstants.POST_METHOD)) {

            new HttpPost(context, url.toString(), mMap, isShowDialog, response, errorResponse, header);

        }
    }

    /*
     * @param requestUrl string type
     * @param HttpUrlConnectionMethod string type use to detect requestMethod (Post,Put,Delete,Get)
     * @param Map Map<String , String> type and this is params send with request as a request body
     * @param callback is VolleyCallback interface this is used to call onSuccess , onCodeError, onVolleyError
     * @param isShowDialog boolean type this use to show load view while request progress or not (true, false)
     * @param header Map<String , String> type and this is header send with request as a request header
     * @return void this function just check if url is valid or not and redirect to makeHttpRequest
     */
    @Override
    public void mRequest(String requestUrl, String HttpUrlConnectionMethod, Map<String, String> Map, VolleyCallback callback,
                         boolean isShowDialog, HashMap<String, String> header) {
        URL url = createUrl(requestUrl);
        try {
            makeHttpRequest(url, HttpUrlConnectionMethod, Map, callback, isShowDialog, header);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } catch (AuthFailureError authFailureError) {
            Log.e(TAG, authFailureError.getMessage());
        }

    }

    /*
     * this header with Auth
     * @param token string type
     * @return map of header
     */
    @Override
    public HashMap<String, String> AuthorizationHeader(String token) {
        HashMap map = new HashMap();
        map.put(VolleyInterActor.AUTH, String.format("%s", token));
        Log.e("params", map.toString());
        return map;
    }


}
