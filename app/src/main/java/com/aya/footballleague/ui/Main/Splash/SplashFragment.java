package com.aya.footballleague.ui.Main.Splash;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aya.footballleague.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashFragment extends Fragment {

    private static final long SPLASH_TIME = 3000;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_splash, container, false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Navigation.findNavController(mRootView).navigate(R.id.action_splashFragment_to_leaguesListFragment);
            }
        }, SPLASH_TIME);
        return mRootView;
    }

}
