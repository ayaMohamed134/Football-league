package com.aya.footballleague.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Player;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.ui.adapters.LeagueAdapter;
import com.aya.footballleague.ui.adapters.PlayerAdapter;
import com.aya.footballleague.ui.adapters.TeamAdapter;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


/**
 * Created by aya mohamed on 08/02/18.
 */

public final class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addPlayersItems(RecyclerView recyclerView, ArrayList<Player> players) {
        PlayerAdapter adapter = (PlayerAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(players);
        }
    }

    @BindingAdapter({"adapter"})
    public static void addLeaguesItems(RecyclerView recyclerView, ArrayList<LeaguesResponse.League> leagues) {
        LeagueAdapter adapter = (LeagueAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(leagues);
        }
    }

    @BindingAdapter({"adapter"})
    public static void addTeamsItems(RecyclerView recyclerView, ArrayList<Team> teams) {
        TeamAdapter adapter = (TeamAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(teams);
        }
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).into(imageView);
    }

}
