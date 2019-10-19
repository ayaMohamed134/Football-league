package com.aya.footballleague.ui.main.leaguesList.teamsList;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TeamsListFragmentProvider {

    @ContributesAndroidInjector(modules = TeamsListFragmentModule.class)
    abstract TeamsListFragment provideTeamsListFragmentFactory();
}
