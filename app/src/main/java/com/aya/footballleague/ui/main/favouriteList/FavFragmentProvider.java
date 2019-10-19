package com.aya.footballleague.ui.main.favouriteList;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FavFragmentProvider {

    @ContributesAndroidInjector(modules = FavFragmentModule.class)
    abstract FavFragment provideFavFragmentFactory();
}
