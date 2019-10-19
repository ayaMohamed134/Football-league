package com.aya.footballleague.ui.main.leaguesList.teamsList;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;
import com.aya.footballleague.ui.base.BaseViewModel;
import com.aya.footballleague.utils.AppConstants;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import java.util.List;

public class TeamsListViewModel extends BaseViewModel {

    public final ObservableArrayList<Team> teams = new ObservableArrayList<>();

    private final MutableLiveData<List<Team>> teamsLiveData;

    public TeamsListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        teamsLiveData = new MutableLiveData<>();
    }

    public void fetchTeams(String league_id) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getTeamsData(AppConstants.API_TOKEN, league_id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(teamsResponse -> {
                    if (teamsResponse.getTeams() != null && teamsResponse.getTeams().size() > 0) {
                        saveDataLocal(teamsResponse);
                        teamsLiveData.setValue(teamsResponse.getTeams());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));

    }

    private void saveDataLocal(TeamsResponse teamsResponse) {
        getCompositeDisposable().add(getDataManager().insertTeams(teamsResponse)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    Log.w("here", String.valueOf(aBoolean));
                }, throwable -> {
                    Log.w("here", throwable.getMessage());
                }));
    }

    public MutableLiveData<List<Team>> getTeamsLiveData() {
        return teamsLiveData;
    }

    public ObservableArrayList<Team> getTeams() {
        return teams;
    }

    public void addTeams(List<Team> teams){
        this.teams.clear();
        this.teams.addAll(teams);
    }
}
