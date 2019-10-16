package com.aya.footballleague.di.module;

import android.app.Application;
import android.content.Context;

import com.aya.footballleague.DataManager.AppDataManager;
import com.aya.footballleague.DataManager.DataManager;
import com.aya.footballleague.DataManager.Remote.ApiHelper;
import com.aya.footballleague.DataManager.Remote.AppApiHelper;
import com.aya.footballleague.DataManager.prefs.AppPreferencesHelper;
import com.aya.footballleague.DataManager.prefs.PreferencesHelper;
import com.aya.footballleague.di.DatabaseInfo;
import com.aya.footballleague.di.PreferenceInfo;
import com.aya.footballleague.utils.AppConstants;
import com.aya.footballleague.utils.rx.AppSchedulerProvider;
import com.aya.footballleague.utils.rx.SchedulerProvider;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * created by Aya mohamed on 8/2/2018.
 */

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }


    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }


    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }


}
