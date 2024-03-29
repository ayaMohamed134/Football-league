package com.aya.footballleague.di.builder;

import com.aya.footballleague.ui.main.Main;
import com.aya.footballleague.ui.main.favouriteList.FavFragmentProvider;
import com.aya.footballleague.ui.main.leaguesList.LeagueListFragmentProvider;
import com.aya.footballleague.ui.main.leaguesList.teamsList.TeamsListFragmentProvider;
import com.aya.footballleague.ui.main.leaguesList.teamsList.teamDetails.TeamDetailsFragmentProvider;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * created by Aya mohamed on 8/2/2018.
 * // TODO add All Activities and fragments here
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {LeagueListFragmentProvider.class, TeamsListFragmentProvider.class,
            TeamDetailsFragmentProvider.class, FavFragmentProvider.class})
    abstract Main bindMainActivity();

}
