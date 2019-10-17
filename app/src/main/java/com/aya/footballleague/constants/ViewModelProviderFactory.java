package com.aya.footballleague.constants;

import com.aya.footballleague.data.DataManager;
import com.aya.footballleague.ui.Main.LeaguesList.LeaguesListViewModel;
import com.aya.footballleague.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

/**
 * created by Aya mohamed on 8/9/2018.
 * <p>
 * A provider factory that persists ViewModels {@link ViewModel}.
 * Used if the view model has a parameterized constructor.
 * // update use NewInstanceFactory instead of Factory
 */
@Singleton
public class ViewModelProviderFactory<V> extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager, SchedulerProvider schedulerProvider){
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LeaguesListViewModel.class)) {
            //noinspection unchecked
            return (T) new LeaguesListViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown class name: " + modelClass.getName());
    }
}
