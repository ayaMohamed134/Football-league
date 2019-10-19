package com.aya.footballleague.ui.main.leaguesList;

import android.util.Log;

import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.MutableLiveData;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.ui.base.BaseViewModel;
import com.aya.footballleague.utils.AppConstants;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import java.util.List;

public class LeaguesListViewModel extends BaseViewModel {

    public final ObservableArrayList<LeaguesResponse.League> leagues = new ObservableArrayList<>();

    private final MutableLiveData<List<LeaguesResponse.League>> leaguesLiveData;

    public LeaguesListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        leaguesLiveData = new MutableLiveData<>();
        fetchLeagues();
    }

    public void fetchLeagues() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getLeaguesData(AppConstants.API_TOKEN)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(leaguesResponse -> {
                    if (leaguesResponse != null && leaguesResponse.size() > 0){
                        saveDataLocal(leaguesResponse);
                        leaguesLiveData.setValue(leaguesResponse);
                    }
                    setIsLoading(false);
                }, throwable -> {
                    Log.w("here", throwable.getMessage());
                    setIsLoading(false);
                }));

    }

    private void saveDataLocal(List<LeaguesResponse.League> leaguesResponse) {
        getCompositeDisposable().add(getDataManager().insertAll(leaguesResponse)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(aBoolean -> {
                    Log.w("here", String.valueOf(aBoolean));
                }, throwable -> {
                    Log.w("here", throwable.getMessage());
                }));
    }

    public ObservableArrayList<LeaguesResponse.League> getLeagues() {
        return leagues;
    }

    public MutableLiveData<List<LeaguesResponse.League>> getLeaguesLiveData() {
        return leaguesLiveData;
    }

    public void addLeagues(List<LeaguesResponse.League> leagues){
        this.leagues.clear();
        this.leagues.addAll(leagues);
    }
}
