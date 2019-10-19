package com.aya.footballleague.ui.adapters;

import androidx.databinding.ObservableField;

import com.aya.footballleague.data.model.Player;

public class PlayerItemViewModel {

    public final ObservableField<String> id;
    public final ObservableField<String> name;
    public final ObservableField<String> position;
    public final ObservableField<String> nationality;

    public PlayerItemViewModel(Player player) {
        this.id = new ObservableField<>(player.getId());
        this.name = new ObservableField<>(player.getName());
        this.nationality = new ObservableField<>(player.getNationality());
        this.position = new ObservableField<>(player.getPosition());
    }


}
