package com.aya.footballleague.DataManager.Remote.VolleyManager;

import com.android.volley.VolleyError;

/**
 * Created by aya mohamed on 17/4/2018.
 */

public interface VolleyCallback {
    void onSuccess(String response);
    void onError(VolleyError volleyError);
    void onErrorCode(String response);
}
