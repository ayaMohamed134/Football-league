package com.aya.footballleague.ui.Adapters;

import com.aya.footballleague.data.model.LeaguesResponse;

import androidx.databinding.ObservableField;

public class LeagueItemViewModel {

    public final ObservableField<String> id;
    public final ObservableField<String> name;
    public final ObservableField<String> number_of_available_seasons;
    public final LeagueItemViewModelListener mListener;

    public LeagueItemViewModel(LeaguesResponse.League league, LeagueItemViewModelListener mListener) {
        this.mListener = mListener;
        this.id = new ObservableField<>(league.getId());
        this.name = new ObservableField<>(league.getName());
        this.number_of_available_seasons = new ObservableField<>(league.getNumberOfAvailableSeasons());
    }

    public void onClickItem(){
        mListener.onItemClick(id.get());
    }

    public interface LeagueItemViewModelListener {
        void onItemClick(String league_id);
    }
}
