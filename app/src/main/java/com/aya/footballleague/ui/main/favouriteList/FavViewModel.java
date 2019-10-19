package com.aya.footballleague.ui.main.favouriteList;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.ui.base.BaseViewModel;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import java.util.List;

public class FavViewModel extends BaseViewModel {

    public final ObservableArrayList<Team> teams = new ObservableArrayList<>();

    private final MutableLiveData<List<Team>> teamsLiveData;

    public FavViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        teamsLiveData = new MutableLiveData<>();
        fetchTeams();
    }

    public void fetchTeams() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getFavTeams()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(teams -> {
                    teamsLiveData.setValue(teams);
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
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
