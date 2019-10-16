package com.aya.footballleague.Views.StartScreen;

import com.aya.footballleague.DataManager.DataManager;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class StartScreenModule {
    @Provides
    StartScreenViewModel provideStartScreenViewModel(DataManager dataManager,
                                                     SchedulerProvider schedulerProvider) {
        return new StartScreenViewModel(dataManager, schedulerProvider);
    }
}
