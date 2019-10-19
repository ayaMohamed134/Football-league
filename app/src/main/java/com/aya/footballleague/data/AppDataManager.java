package com.aya.footballleague.data;

import android.content.Context;

import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;
import com.aya.footballleague.data.remote.ApiHelper;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.prefs.PreferencesHelper;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * created by Aya mohamed on 8/2/2018.
 */

@Singleton
public class AppDataManager implements DataManager {

    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;
    private final Gson mGson;
    private final Context mContext;

    @Inject
    public AppDataManager(Context context, PreferencesHelper mPreferencesHelper,
                          ApiHelper mApiHelper, Gson mGson) {
        this.mPreferencesHelper = mPreferencesHelper;
        this.mApiHelper = mApiHelper;
        this.mGson = mGson;
        this.mContext = context;
    }

    @Override
    public Single<LeaguesResponse> getLeagues(String apiToken) {
        return mApiHelper.getLeagues(apiToken);
    }

    @Override
    public Single<TeamsResponse> getTeams(String apiToken, String league_id) {
        return mApiHelper.getTeams(apiToken, league_id);
    }

    @Override
    public Single<Team> getTeam(String apiToken, String team_id) {
        return mApiHelper.getTeam(apiToken, team_id);
    }
}
