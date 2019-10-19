package com.aya.footballleague.ui.main.leaguesList.teamsList.teamDetails;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aya.footballleague.BR;
import com.aya.footballleague.R;
import com.aya.footballleague.constants.ViewModelProviderFactory;
import com.aya.footballleague.databinding.FragmentTeamDetailsBinding;
import com.aya.footballleague.ui.adapters.PlayerAdapter;
import com.aya.footballleague.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamDetailsFragment extends BaseFragment<FragmentTeamDetailsBinding, TeamDetailsViewModel>
        implements PlayerAdapter.PlayerAdapterListener {

    @Inject
    PlayerAdapter mPlayerAdapter;
    private FragmentTeamDetailsBinding mFragmentTeamDetailsBinding;
    @Inject
    ViewModelProviderFactory factory;
    private  TeamDetailsViewModel mTeamDetailsViewModel;
    private TeamDetailsFragmentArgs args;
    private String team_id;

    public TeamDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_team_details;
    }

    @Override
    public TeamDetailsViewModel getViewModel() {
        mTeamDetailsViewModel = ViewModelProviders.of(this, factory).get(TeamDetailsViewModel.class);
        return mTeamDetailsViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlayerAdapter.setmListener(this);
        args = TeamDetailsFragmentArgs.fromBundle(requireArguments());
        team_id = args.getTeamId();
        mTeamDetailsViewModel.fetchTeam(team_id);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentTeamDetailsBinding = getViewDataBinding();
        setUp();
        subscribeLiveData();
    }

    private void setUp() {
        mFragmentTeamDetailsBinding.rvPlayers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mFragmentTeamDetailsBinding.rvPlayers.setItemAnimator(new DefaultItemAnimator());
        mFragmentTeamDetailsBinding.rvPlayers.setAdapter(mPlayerAdapter);
        mFragmentTeamDetailsBinding.rvPlayers.setNestedScrollingEnabled(false);
    }

    private void subscribeLiveData() {
        mTeamDetailsViewModel.getTeamLiveData().observe(this, team -> mTeamDetailsViewModel.addTeam(team));
        mTeamDetailsViewModel.getPlayersLiveData().observe(this, players -> mTeamDetailsViewModel.addPlayers(players));
    }


    @Override
    public void onRetryClick() {
        mTeamDetailsViewModel.fetchTeam(team_id);
    }
}
