package com.aya.footballleague.ui.main.leaguesList.teamsList.teamDetails;

import com.aya.footballleague.ui.adapters.PlayerAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class TeamDetailsFragmentModule {

    @Provides
    PlayerAdapter providePlayerAdapter(){
        return new PlayerAdapter(new ArrayList<>());
    }

}
