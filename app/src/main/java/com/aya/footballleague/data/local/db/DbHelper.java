package com.aya.footballleague.data.local.db;

import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by aya mohamed on 09/10/18.
 */

public interface DbHelper {

    Single<List<LeaguesResponse.League>> getAllLeagues();

    Observable<Boolean> insertAll(List<LeaguesResponse.League> leagues);

    Single<TeamsResponse> getTeams(String league_id);

    Observable<Boolean> insertTeams(TeamsResponse teams);

    Single<Team> getTeam(String team_id);

    Observable<Boolean> insertTeam(Team team);

}