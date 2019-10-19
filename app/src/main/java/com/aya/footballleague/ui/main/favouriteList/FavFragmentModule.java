package com.aya.footballleague.ui.main.favouriteList;

import com.aya.footballleague.ui.adapters.TeamAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class FavFragmentModule {

    @Provides
    TeamAdapter provideTeamAdapter(){
        return new TeamAdapter(new ArrayList<>());
    }

}
