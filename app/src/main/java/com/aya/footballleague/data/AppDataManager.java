package com.aya.footballleague.data;

import android.content.Context;

import com.aya.footballleague.data.local.db.DbHelper;
import com.aya.footballleague.data.local.prefs.PreferencesHelper;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;
import com.aya.footballleague.data.remote.ApiHelper;
import com.aya.footballleague.utils.NetworkUtils;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * created by Aya mohamed on 8/2/2018.
 */

@Singleton
public class AppDataManager implements DataManager {

    private final PreferencesHelper mPreferencesHelper;
    private final DbHelper mDbHelper;
    private final ApiHelper mApiHelper;
    private final Gson mGson;
    private final Context mContext;

    @Inject
    public AppDataManager(Context context, PreferencesHelper mPreferencesHelper,
                          ApiHelper mApiHelper, Gson mGson, DbHelper mDbHelper) {
        this.mPreferencesHelper = mPreferencesHelper;
        this.mApiHelper = mApiHelper;
        this.mDbHelper = mDbHelper;
        this.mGson = mGson;
        this.mContext = context;
    }

    @Override
    public Single<List<LeaguesResponse.League>> getLeagues(String apiToken) {
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

    @Override
    public Single<List<LeaguesResponse.League>> getAllLeagues() {
        return mDbHelper.getAllLeagues();
    }

    @Override
    public Observable<Boolean> insertAll(List<LeaguesResponse.League> leagues) {
        return mDbHelper.insertAll(leagues);
    }

    @Override
    public Single<TeamsResponse> getTeams(String league_id) {
        return mDbHelper.getTeams(league_id);
    }

    @Override
    public Observable<Boolean> insertTeams(TeamsResponse teams) {
        return mDbHelper.insertTeams(teams);
    }

    @Override
    public Single<Team> getTeam(String team_id) {
        return mDbHelper.getTeam(team_id);
    }

    @Override
    public Observable<Boolean> insertTeam(Team team) {
        return mDbHelper.insertTeam(team);
    }

    @Override
    public Single<List<LeaguesResponse.League>> getLeaguesData(String apiToken) {
        if (NetworkUtils.isNetworkConnected(mContext)) {
           return getLeagues(apiToken);
        } else {
            return getAllLeagues();
        }
    }

    @Override
    public Single<TeamsResponse> getTeamsData(String apiToken, String league_id) {
        if (NetworkUtils.isNetworkConnected(mContext)) {
            return getTeams(apiToken, league_id);
        } else {
            return getTeams(league_id);
        }
    }

    @Override
    public Single<Team> getTeamData(String apiToken, String team_id) {
        if (NetworkUtils.isNetworkConnected(mContext)) {
            return getTeam(apiToken, team_id);
        } else {
            return getTeam(team_id);
        }
    }
}
