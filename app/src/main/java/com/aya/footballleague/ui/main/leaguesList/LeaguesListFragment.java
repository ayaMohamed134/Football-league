package com.aya.footballleague.ui.main.leaguesList;


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
import com.aya.footballleague.databinding.FragmentLeaguesListBinding;
import com.aya.footballleague.ui.adapters.LeagueAdapter;
import com.aya.footballleague.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeaguesListFragment extends BaseFragment<FragmentLeaguesListBinding, LeaguesListViewModel>
        implements LeagueAdapter.LeagueAdapterListener {

    @Inject
    LeagueAdapter mLeagueAdapter;
    private FragmentLeaguesListBinding mFragmentLeaguesListBinding;
    @Inject
    ViewModelProviderFactory factory;
    private LeaguesListViewModel mLeaguesListViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_leagues_list;
    }

    @Override
    public LeaguesListViewModel getViewModel() {
        mLeaguesListViewModel = ViewModelProviders.of(this, factory).get(LeaguesListViewModel.class);
        return mLeaguesListViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLeagueAdapter.setListener(this);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentLeaguesListBinding = getViewDataBinding();
        setUp();
        subscribeLiveData();
    }

    private void setUp() {
        mFragmentLeaguesListBinding.rvLeagues.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mFragmentLeaguesListBinding.rvLeagues.setItemAnimator(new DefaultItemAnimator());
        mFragmentLeaguesListBinding.rvLeagues.setAdapter(mLeagueAdapter);
    }

    private void subscribeLiveData() {
        mLeaguesListViewModel.getLeaguesLiveData().observe(this, leagues -> mLeaguesListViewModel.addLeagues(leagues));
    }

    @Override
    public void onItemClicked(String league_id) {
        LeaguesListFragmentDirections.ActionLeaguesListFragmentToTeamsListFragment direction
                = LeaguesListFragmentDirections.actionLeaguesListFragmentToTeamsListFragment().setLeagueId(league_id);
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(direction);
    }

    @Override
    public void onRetryClick() {
        mLeaguesListViewModel.fetchLeagues();
    }


}
