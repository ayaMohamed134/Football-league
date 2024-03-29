package com.aya.footballleague.ui.main;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.aya.footballleague.R;
import com.aya.footballleague.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class Main extends AppCompatActivity implements HasSupportFragmentInjector {

    private NavController navController;
    private ActivityMainBinding mMainBinding;
    private AppBarConfiguration appBarConfiguration;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupUI();

    }

    private void setupUI() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller,
                                             @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.splashFragment) {
                    mMainBinding.appBar.setVisibility(View.GONE);
                } else {
                    mMainBinding.appBar.setVisibility(View.VISIBLE);
                }
            }
        });
        setSupportActionBar(mMainBinding.toolbar);
        appBarConfiguration = new AppBarConfiguration.Builder(R.id.leaguesListFragment, R.id.favFragment)
                .setDrawerLayout(mMainBinding.drawerLayout)
                .build();
        NavigationUI.setupWithNavController(mMainBinding.toolbar, navController, appBarConfiguration);
        (mMainBinding.drawerLayout).setStatusBarBackground(R.color.colorPrimaryDark);
        NavigationUI.setupWithNavController(mMainBinding.navView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
