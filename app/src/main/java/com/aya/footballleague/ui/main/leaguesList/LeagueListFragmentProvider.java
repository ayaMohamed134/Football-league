package com.aya.footballleague.ui.main.leaguesList;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LeagueListFragmentProvider {

    @ContributesAndroidInjector(modules = LeaguesListFragmentModule.class)
    abstract LeaguesListFragment provideLeaguesListFragmentFactory();
}
