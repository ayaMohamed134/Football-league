package com.aya.footballleague.data.Remote;


import com.aya.footballleague.data.model.LeaguesResponse;
import io.reactivex.Single;

/**
 * created by Aya mohamed on 9/11/2018.
 */
public interface ApiHelper {

    Single<LeaguesResponse> getLeagues(String apiToken, String areasValue);
}
