package com.aya.footballleague.data;


import com.aya.footballleague.data.local.db.DbHelper;
import com.aya.footballleague.data.local.prefs.PreferencesHelper;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;
import com.aya.footballleague.data.remote.ApiHelper;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by aya mohamed on 08/02/18.
 */

public interface DataManager extends PreferencesHelper, ApiHelper, DbHelper {

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_CLIENT_LOGIN(1);

        private final int mType;

        LoggedInMode(int mType) {
            this.mType = mType;
        }

        public int getType() {
            return mType;
        }

    }

    Single<List<LeaguesResponse.League>> getLeaguesData(String apiToken);

    Single<TeamsResponse> getTeamsData(String apiToken, String league_id);

    Single<Team> getTeamData(String apiToken, String team_id);
}
