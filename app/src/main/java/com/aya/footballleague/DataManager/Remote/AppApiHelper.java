package com.aya.footballleague.DataManager.Remote;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;
import com.aya.footballleague.DataManager.Remote.VolleyManager.VolleyCallback;
import com.aya.footballleague.DataManager.Remote.VolleyManager.VolleyInterActor;
import com.aya.footballleague.utils.AppConstants;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

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


}
