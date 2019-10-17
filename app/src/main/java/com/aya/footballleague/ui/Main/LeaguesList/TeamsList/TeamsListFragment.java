package com.aya.footballleague.ui.Main.LeaguesList.TeamsList;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aya.footballleague.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsListFragment extends Fragment {


    public TeamsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teams_list, container, false);
    }

}
