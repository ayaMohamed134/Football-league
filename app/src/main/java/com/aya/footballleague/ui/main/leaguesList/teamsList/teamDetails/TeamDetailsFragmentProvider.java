package com.aya.footballleague.ui.main.leaguesList.teamsList.teamDetails;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TeamDetailsFragmentProvider {

    @ContributesAndroidInjector(modules = TeamDetailsFragmentModule.class)
    abstract TeamDetailsFragment provideTeamDetailsFragmentFragmentFactory();
}
