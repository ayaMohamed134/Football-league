package com.aya.footballleague.di.builder;

import com.aya.footballleague.ui.Main.LeaguesList.LeagueListFragmentProvider;
import com.aya.footballleague.ui.Main.Main;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * created by Aya mohamed on 8/2/2018.
 * // TODO add All Activities and fragments here
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {LeagueListFragmentProvider.class})
    abstract Main bindMainActivity();
    
}
