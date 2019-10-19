package com.aya.footballleague.ui.main.favouriteList;


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
import com.aya.footballleague.databinding.FragmentFavBinding;
import com.aya.footballleague.ui.adapters.TeamAdapter;
import com.aya.footballleague.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavFragment extends BaseFragment<FragmentFavBinding, FavViewModel>
        implements TeamAdapter.TeamAdapterListener {

    @Inject
    TeamAdapter mTeamAdapter;
    private FragmentFavBinding mFragmentFavBinding;
    @Inject
    ViewModelProviderFactory factory;
    private FavViewModel mFavViewModel;


    public FavFragment() {
        // Required empty public constructor
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_fav;
    }

    @Override
    public FavViewModel getViewModel() {
        mFavViewModel = ViewModelProviders.of(this, factory).get(FavViewModel.class);
        return mFavViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTeamAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentFavBinding = getViewDataBinding();
        setUp();
        subscribeLiveData();
    }

    private void setUp() {
        mFragmentFavBinding.rvTeams.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mFragmentFavBinding.rvTeams.setItemAnimator(new DefaultItemAnimator());
        mFragmentFavBinding.rvTeams.setAdapter(mTeamAdapter);
    }

    private void subscribeLiveData() {
        mFavViewModel.getTeamsLiveData().observe(this, teams -> mFavViewModel.addTeams(teams));
    }

    @Override
    public void onItemClicked(String team_id) {
        FavFragmentDirections.ActionFavFragmentToTeamDetailsFragment direction =
                FavFragmentDirections.actionFavFragmentToTeamDetailsFragment().setTeamId(team_id);
        Navigation.findNavController(getActivity(), R.id.nav_host_fragment).navigate(direction);
    }

    @Override
    public void onRetryClick() {
        mFavViewModel.fetchTeams();
    }
}
