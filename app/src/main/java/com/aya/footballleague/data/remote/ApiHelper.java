package com.aya.footballleague.data.remote;


import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.TeamsResponse;

import io.reactivex.Single;

/**
 * created by Aya mohamed on 9/11/2018.
 */
public interface ApiHelper {

    Single<LeaguesResponse> getLeagues(String apiToken, String areasValue);

    Single<TeamsResponse> getTeams(String apiToken, String team_id);
}
