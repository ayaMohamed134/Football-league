package com.aya.footballleague.DataManager.Remote.VolleyManager.VolleyNetwork;

import com.android.volley.VolleyError;

/**
 * Created by aya mohamed on 17/4/2018.
 */

public interface HttpError {
    void onHttpError(VolleyError volleyError);
}
