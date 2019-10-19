package com.aya.footballleague.ui.main.leaguesList.teamsList;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.ui.base.BaseViewModel;
import com.aya.footballleague.utils.AppConstants;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import java.util.ArrayList;

public class TeamsListViewModel extends BaseViewModel {

    public final ObservableArrayList<Team> teams = new ObservableArrayList<>();

    private final MutableLiveData<ArrayList<Team>> teamsLiveData;

    public TeamsListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        teamsLiveData = new MutableLiveData<>();
    }

    public void fetchTeams(String team_id) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getTeams(AppConstants.API_TOKEN, team_id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(teamsResponse -> {
                    if (teamsResponse.getTeams() != null && teamsResponse.getTeams().size() > 0)
                        teamsLiveData.setValue(teamsResponse.getTeams());
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));

    }

    public MutableLiveData<ArrayList<Team>> getTeamsLiveData() {
        return teamsLiveData;
    }

    public ObservableArrayList<Team> getTeams() {
        return teams;
    }

    public void addTeams(ArrayList<Team> teams){
        this.teams.clear();
        this.teams.addAll(teams);
    }
}
