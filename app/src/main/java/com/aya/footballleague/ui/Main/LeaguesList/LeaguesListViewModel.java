package com.aya.footballleague.ui.Main.LeaguesList;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.ui.Base.BaseViewModel;
import com.aya.footballleague.utils.AppConstants;
import com.aya.footballleague.utils.rx.SchedulerProvider;

public class LeaguesListViewModel extends BaseViewModel {

    public LeaguesListViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        fetchLeagues();
    }

    public void fetchLeagues() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getLeagues(AppConstants.API_TOKEN, AppConstants.AREAS_VALUE)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(leaguesResponse -> {

                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));

    }
}
