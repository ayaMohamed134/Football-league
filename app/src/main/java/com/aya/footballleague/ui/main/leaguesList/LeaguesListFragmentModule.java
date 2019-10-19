package com.aya.footballleague.ui.main.leaguesList;

import com.aya.footballleague.ui.adapters.LeagueAdapter;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class LeaguesListFragmentModule {

    @Provides
    LeagueAdapter provideLeagueAdapter(){
        return new LeagueAdapter(new ArrayList<>());
    }

}
