package com.aya.footballleague.ui.Main.LeaguesList;

import com.aya.footballleague.ui.Adapters.LeagueAdapter;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;

@Module
public class LeaguesListFragmentModule {

    @Provides
    LeagueAdapter provideLeagueAdapter(){
        return new LeagueAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(LeaguesListFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
