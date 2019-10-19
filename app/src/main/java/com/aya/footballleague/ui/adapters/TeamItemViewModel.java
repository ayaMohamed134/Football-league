package com.aya.footballleague.ui.adapters;

import androidx.databinding.ObservableField;

import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.utils.AppConstants;

public class TeamItemViewModel {

    public final ObservableField<String> id;
    public final ObservableField<String> name;
    public final ObservableField<String> shortName;
    public final ObservableField<String> image;
    public final TeamItemViewModelListener mListener;

    public TeamItemViewModel(Team team, TeamItemViewModelListener mListener) {
        this.mListener = mListener;
        this.id = new ObservableField<>(team.getId());
        this.name = new ObservableField<>(team.getName());
        this.shortName = new ObservableField<>(team.getShortName());
        if(team.getCrestUrl() == null){
            this.image = new ObservableField<>(AppConstants.DEFAULT_IMAGE);
        }else {
            this.image = new ObservableField<>(team.getCrestUrl());
        }
    }

    public void onClickItem(){
        mListener.onItemClick(id.get());
    }

    public interface TeamItemViewModelListener {
        void onItemClick(String team_id);
    }
}
