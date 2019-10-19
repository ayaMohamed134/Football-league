package com.aya.footballleague.ui.main.leaguesList.teamsList;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aya.footballleague.BR;
import com.aya.footballleague.R;
import com.aya.footballleague.constants.ViewModelProviderFactory;
import com.aya.footballleague.databinding.FragmentTeamsListBinding;
import com.aya.footballleague.ui.adapters.TeamAdapter;
import com.aya.footballleague.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamsListFragment extends BaseFragment<FragmentTeamsListBinding, TeamsListViewModel>
        implements TeamAdapter.TeamAdapterListener {

    @Inject
    TeamAdapter mTeamAdapter;
    private FragmentTeamsListBinding mFragmentTeamsListBinding;
    @Inject
    ViewModelProviderFactory factory;
    private TeamsListViewModel mTeamsListViewModel;

    private TeamsListFragmentArgs args;
    private String league_id;

    public TeamsListFragment() {
        // Required empty public constructor
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_teams_list;
    }

    @Override
    public TeamsListViewModel getViewModel() {
        mTeamsListViewModel = ViewModelProviders.of(this, factory).get(TeamsListViewModel.class);
        return mTeamsListViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTeamAdapter.setListener(this);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentTeamsListBinding = getViewDataBinding();
        setUp();
        subscribeLiveData();
    }

    private void setUp() {
        mFragmentTeamsListBinding.rvTeams.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mFragmentTeamsListBinding.rvTeams.setItemAnimator(new DefaultItemAnimator());
        mFragmentTeamsListBinding.rvTeams.setAdapter(mTeamAdapter);
        args = TeamsListFragmentArgs.fromBundle(requireArguments());
        league_id = args.getLeagueId();
        mTeamsListViewModel.fetchTeams(league_id);
    }

    private void subscribeLiveData() {
        mTeamsListViewModel.getTeamsLiveData().observe(this, teams -> mTeamsListViewModel.addTeams(teams));
    }

    @Override
    public void onItemClicked(String team_id) {
        TeamsListFragmentDirections.ActionTeamsListFragmentToTeamDetailsFragment direction =
                TeamsListFragmentDirections.actionTeamsListFragmentToTeamDetailsFragment().setTeamId(team_id);
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(direction);
    }

    @Override
    public void onRetryClick() {
        mTeamsListViewModel.fetchTeams(league_id);
    }
}
