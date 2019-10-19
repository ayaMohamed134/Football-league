package com.aya.footballleague.ui.main.leaguesList;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.ui.base.BaseViewModel;
import com.aya.footballleague.utils.AppConstants;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import java.util.ArrayList;

public class LeaguesListViewModel extends BaseViewModel {

    public final ObservableArrayList<LeaguesResponse.League> leagues = new ObservableArrayList<>();

    private final MutableLiveData<ArrayList<LeaguesResponse.League>> leaguesLiveData;

    public LeaguesListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        leaguesLiveData = new MutableLiveData<>();
        fetchLeagues();
    }

    public void fetchLeagues() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getLeagues(AppConstants.API_TOKEN)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(leaguesResponse -> {
                    if (leaguesResponse.getCompetitions() != null && leaguesResponse.getCompetitions().size() > 0)
                        leaguesLiveData.setValue(leaguesResponse.getCompetitions());
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));

    }

    public ObservableArrayList<LeaguesResponse.League> getLeagues() {
        return leagues;
    }

    public MutableLiveData<ArrayList<LeaguesResponse.League>> getLeaguesLiveData() {
        return leaguesLiveData;
    }

    public void addLeagues(ArrayList<LeaguesResponse.League> leagues){
        this.leagues.clear();
        this.leagues.addAll(leagues);
    }
}
