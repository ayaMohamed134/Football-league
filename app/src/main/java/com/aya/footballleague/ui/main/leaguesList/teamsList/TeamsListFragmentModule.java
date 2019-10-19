package com.aya.footballleague.ui.main.leaguesList.teamsList;

import com.aya.footballleague.ui.adapters.TeamAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class TeamsListFragmentModule {

    @Provides
    TeamAdapter provideTeamAdapter(){
        return new TeamAdapter(new ArrayList<>());
    }

}
