package com.aya.footballleague.Views.StartScreen;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.aya.footballleague.BR;
import com.aya.footballleague.R;
import com.aya.footballleague.Views.Base.BaseActivity;
import com.aya.footballleague.databinding.ActivityStartScreenBinding;

import javax.inject.Inject;

public class StartScreen extends BaseActivity<ActivityStartScreenBinding, StartScreenViewModel> {

    @Inject
    StartScreenViewModel mStartScreenViewModel;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_start_screen;
    }

    @Override
    public StartScreenViewModel getViewModel() {
        return mStartScreenViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscribeToLiveData();
    }

    private void subscribeToLiveData() {

    }
}
