package com.aya.footballleague.ui.main.leaguesList.teamsList.teamDetails;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.data.model.Player;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.ui.base.BaseViewModel;
import com.aya.footballleague.utils.AppConstants;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import java.util.ArrayList;

public class TeamDetailsViewModel extends BaseViewModel {

    public final ObservableField<Team> team = new ObservableField<>();
    public final ObservableField<String> image = new ObservableField<>();
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> shortName = new ObservableField<>();
    public final ObservableField<String> address = new ObservableField<>();
    public final ObservableField<String> website = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableArrayList<Player> players = new ObservableArrayList<>();

    private final MutableLiveData<Team> teamLiveData;
    private final MutableLiveData<ArrayList<Player>> playersLiveData;

    public TeamDetailsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        teamLiveData = new MutableLiveData<>();
        playersLiveData = new MutableLiveData<>();
    }

    public void fetchTeam(String team_id) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getTeamData(AppConstants.API_TOKEN, team_id)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(team -> {
                    if (team != null){
                        saveDataLocal(team);
                        teamLiveData.setValue(team);
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));

    }

    private void saveDataLocal(Team team) {
        getCompositeDisposable().add(getDataManager().insertTeam(team)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    Log.w("here", String.valueOf(aBoolean));
                }, throwable -> {
                    Log.w("here", throwable.getMessage());
                }));
    }

    public ObservableField<Team> getTeam() {
        return team;
    }

    public MutableLiveData<Team> getTeamLiveData() {
        return teamLiveData;
    }

    public MutableLiveData<ArrayList<Player>> getPlayersLiveData() {
        return playersLiveData;
    }

    public ObservableArrayList<Player> getPlayers() {
        return players;
    }

    public void addTeam(Team team) {
        this.team.set(team);
        this.name.set(team.getName());
        this.shortName.set(team.getShortName());
        this.address.set(team.getAddress());
        this.website.set(team.getWebsite());
        this.email.set(team.getEmail());
        if (team.getCrestUrl() == null){
            this.image.set(AppConstants.DEFAULT_IMAGE);
        }else {
            this.image.set(team.getCrestUrl());
        }
        playersLiveData.setValue(team.getSquad());
    }

    public void addPlayers(ArrayList<Player> players) {
        this.players.clear();
        this.players.addAll(players);
    }
}
