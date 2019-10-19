package com.aya.footballleague.data.local.db;

import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

/**
 * Created by Aya Mohamed on 9/18/2018.
 */
@Singleton
public class AppDbHelper implements DbHelper {

    private final AppRoomDatabase mAppRoomDatabase;

    @Inject
    public AppDbHelper(AppRoomDatabase appRoomDatabase) {
        this.mAppRoomDatabase = appRoomDatabase;
    }

    @Override
    public Single<List<LeaguesResponse.League>> getAllLeagues() {
        return Single.create(new SingleOnSubscribe<List<LeaguesResponse.League>>() {
            @Override
            public void subscribe(SingleEmitter<List<LeaguesResponse.League>> e) throws Exception {
                //Log.w("here", mAppRoomDatabase.leagueDao().loadAll().toString());
                e.onSuccess(mAppRoomDatabase.leagueDao().loadAll());
            }
        });
    }

    @Override
    public Observable<Boolean> insertAll(List<LeaguesResponse.League> leagues) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppRoomDatabase.leagueDao().insertAll(leagues);
                return true;
            }
        });
    }

    @Override
    public Single<TeamsResponse> getTeams(String league_id) {
        return Single.create(new SingleOnSubscribe<TeamsResponse>() {
            @Override
            public void subscribe(SingleEmitter<TeamsResponse> e) throws Exception {
                List<TeamsResponse> teamsResponses = mAppRoomDatabase.teamsDao().loadAll();
                for (int i = 0; i < teamsResponses.size(); i++){
                    if (teamsResponses.get(i).getCompetition().getId().equals(league_id)){
                        //Log.w("here**", teamsResponses.get(i).getCompetition().getId() + " league:" + league_id);
                        e.onSuccess(teamsResponses.get(i));
                    }
                }
            }
        });
    }

    @Override
    public Observable<Boolean> insertTeams(TeamsResponse teams) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppRoomDatabase.teamsDao().insert(teams);
                return true;
            }
        });
    }

    @Override
    public Single<Team> getTeam(String team_id) {
        return Single.create(new SingleOnSubscribe<Team>() {
            @Override
            public void subscribe(SingleEmitter<Team> e) throws Exception {
                //Log.w("here", mAppRoomDatabase.leagueDao().loadAll().toString());
                e.onSuccess(mAppRoomDatabase.teamDao().loadTeam(team_id));
            }
        });
    }

    @Override
    public Observable<Boolean> insertTeam(Team team) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppRoomDatabase.teamDao().insert(team);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> addFav(String is_fav, String team_id) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppRoomDatabase.teamDao().update(is_fav, team_id);
                return true;
            }
        });
    }

    @Override
    public Observable<List<Team>> getFavTeams() {
        return Observable.fromCallable(new Callable<List<Team>>() {
            @Override
            public List<Team> call() throws Exception {
               return mAppRoomDatabase.teamDao().loadFavTeams();
            }
        });
    }


}
