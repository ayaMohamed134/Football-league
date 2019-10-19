package com.aya.footballleague.data.remote;


import com.aya.footballleague.BuildConfig;

/**
 * created by Aya mohamed on 9/11/2018.
 */
public final class ApiEndPoint {

    public static final String ENDPOINT_LEAGUES = BuildConfig.BASE_URL + "competitions?plan=TIER_ONE";
    public static final String ENDPOINT_TEAMS = BuildConfig.BASE_URL + "competitions/";
    public static final String TEAMS = "/teams/";
    public static final String ENDPOINT_TEAM = BuildConfig.BASE_URL + "teams/";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}

