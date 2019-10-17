package com.aya.footballleague.data.Remote;

import android.content.Context;

import com.aya.footballleague.data.Remote.VolleyManager.VolleyInterActor;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * created by Aya mohamed on 9/11/2018.
 */

@Singleton
public class AppApiHelper implements ApiHelper {

    private final static String TAG = AppApiHelper.class.getSimpleName();
    @Inject
    VolleyInterActor volleyInterActor;
    @Inject
    Context context;
    @Inject
    Gson gson;
    String url = "";

    @Inject
    public AppApiHelper() {

    }


    @Override
    public Single<LeaguesResponse> getLeagues(String apiToken, String areasValue) {
        return null;
    }
}
