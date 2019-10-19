package com.aya.footballleague.data.remote.volleyManager.volleyNetwork;

import com.android.volley.VolleyError;

/**
 * Created by aya mohamed on 17/4/2018.
 */

public interface HttpError {
    void onHttpError(VolleyError volleyError);
}
