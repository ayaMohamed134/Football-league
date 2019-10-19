package com.aya.footballleague.data.remote;

import android.content.Context;
import android.util.Log;

import com.android.volley.VolleyError;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;
import com.aya.footballleague.data.remote.volleyManager.VolleyCallback;
import com.aya.footballleague.data.remote.volleyManager.VolleyInterActor;
import com.aya.footballleague.utils.AppConstants;
import com.google.gson.Gson;

import java.util.List;

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


    @Inject
    public AppApiHelper() {

    }


    @Override
    public Single<List<LeaguesResponse.League>> getLeagues(String apiToken) {
        return Single.create(new SingleOnSubscribe<List<LeaguesResponse.League>>() {
            @Override
            public void subscribe(SingleEmitter<List<LeaguesResponse.League>> e) throws Exception {
                volleyInterActor.mRequest(ApiEndPoint.ENDPOINT_LEAGUES, AppConstants.GET_METHOD,
                        null, new VolleyCallback() {
                            @Override
                            public void onSuccess(String response) {
                                if (response != null) {
                                    Log.i("response", response);
                                    LeaguesResponse leaguesResponse = gson.fromJson(response, LeaguesResponse.class);
                                    e.onSuccess(leaguesResponse.getCompetitions());
                                }
                            }

                            @Override
                            public void onError(VolleyError volleyError) {
                                e.onError(volleyError);
                            }

                            @Override
                            public void onErrorCode(String response) {
                                Log.i("response", response);
                                LeaguesResponse leaguesResponse = gson.fromJson(response, LeaguesResponse.class);
                                e.onSuccess(leaguesResponse.getCompetitions());
                            }
                        }, true, volleyInterActor.AuthorizationHeader(apiToken));
            }
        });
    }

    @Override
    public Single<TeamsResponse> getTeams(String apiToken, String league_id) {
        return Single.create(new SingleOnSubscribe<TeamsResponse>() {
            @Override
            public void subscribe(SingleEmitter<TeamsResponse> e) throws Exception {
                volleyInterActor.mRequest(ApiEndPoint.ENDPOINT_TEAMS + league_id + ApiEndPoint.TEAMS, AppConstants.GET_METHOD,
                        null, new VolleyCallback() {
                            @Override
                            public void onSuccess(String response) {
                                if (response != null) {
                                    Log.i("response", response);
                                    TeamsResponse teamsResponse = gson.fromJson(response, TeamsResponse.class);
                                    e.onSuccess(teamsResponse);
                                }
                            }

                            @Override
                            public void onError(VolleyError volleyError) {
                                e.onError(volleyError);
                            }

                            @Override
                            public void onErrorCode(String response) {
                                Log.i("response", response);
                                TeamsResponse teamsResponse = gson.fromJson(response, TeamsResponse.class);
                                e.onSuccess(teamsResponse);
                            }
                        }, true, volleyInterActor.AuthorizationHeader(apiToken));
            }
        });
    }

    @Override
    public Single<Team> getTeam(String apiToken, String team_id) {
        return Single.create(new SingleOnSubscribe<Team>() {
            @Override
            public void subscribe(SingleEmitter<Team> e) throws Exception {
                volleyInterActor.mRequest(ApiEndPoint.ENDPOINT_TEAM + team_id, AppConstants.GET_METHOD,
                        null, new VolleyCallback() {
                            @Override
                            public void onSuccess(String response) {
                                if (response != null) {
                                    Log.i("response", response);
                                    Team teamResponse = gson.fromJson(response, Team.class);
                                    e.onSuccess(teamResponse);
                                }
                            }

                            @Override
                            public void onError(VolleyError volleyError) {
                                e.onError(volleyError);
                            }

                            @Override
                            public void onErrorCode(String response) {
                                Log.i("response", response);
                                Team teamResponse = gson.fromJson(response, Team.class);
                                e.onSuccess(teamResponse);
                            }
                        }, true, volleyInterActor.AuthorizationHeader(apiToken));
            }
        });
    }
}
