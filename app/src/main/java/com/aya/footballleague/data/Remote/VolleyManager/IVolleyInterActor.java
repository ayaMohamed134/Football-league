package com.aya.footballleague.data.Remote.VolleyManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aya Mohamed on 17/4/2018.
 */

public interface IVolleyInterActor {
    HashMap<String, String> NormalHeader();
    HashMap<String, String> AuthorizationHeader(String token);
    void mRequest(String requestUrl, String HttpUrlConnectionMethod, Map<String, String> Map, VolleyCallback callback, boolean isShowDialog, HashMap<String, String> header);
}
