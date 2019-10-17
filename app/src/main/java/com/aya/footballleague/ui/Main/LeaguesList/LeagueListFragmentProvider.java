package com.aya.footballleague.ui.Main.LeaguesList;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LeagueListFragmentProvider {

    @ContributesAndroidInjector(modules = LeaguesListFragmentModule.class)
    abstract LeaguesListFragment provideLeaguesListFragmentFactory();
}
