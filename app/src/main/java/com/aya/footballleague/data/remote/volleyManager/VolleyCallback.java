package com.aya.footballleague.data.remote.volleyManager;

import com.android.volley.VolleyError;

/**
 * Created by aya mohamed on 17/4/2018.
 */

public interface VolleyCallback {
    void onSuccess(String response);
    void onError(VolleyError volleyError);
    void onErrorCode(String response);
}
