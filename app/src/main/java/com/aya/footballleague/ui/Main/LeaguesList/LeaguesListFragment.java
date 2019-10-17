package com.aya.footballleague.ui.Main.LeaguesList;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aya.footballleague.BR;
import com.aya.footballleague.R;
import com.aya.footballleague.constants.ViewModelProviderFactory;
import com.aya.footballleague.databinding.FragmentLeaguesListBinding;
import com.aya.footballleague.ui.Adapters.LeagueAdapter;
import com.aya.footballleague.ui.Base.BaseFragment;

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
    LinearLayoutManager mLinearLayoutManager;
    @Inject
    ViewModelProviderFactory factory;
    private LeaguesListViewModel mLeaguesListViewModel;

    public static LeaguesListFragment newInstance() {
        Bundle args = new Bundle();
        LeaguesListFragment fragment = new LeaguesListFragment();
        fragment.setArguments(args);
        return fragment;
    }

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
    }

    private void setUp() {
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentLeaguesListBinding.rvLeagues.setLayoutManager(mLinearLayoutManager);
        mFragmentLeaguesListBinding.rvLeagues.setItemAnimator(new DefaultItemAnimator());
        mFragmentLeaguesListBinding.rvLeagues.setAdapter(mLeagueAdapter);
    }

    @Override
    public void onItemClicked(String league_id) {
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(R.id.action_leaguesListFragment_to_teamsListFragment);
    }

    @Override
    public void onRetryClick() {
        mLeaguesListViewModel.fetchLeagues();
    }
}
