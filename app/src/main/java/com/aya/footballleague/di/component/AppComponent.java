package com.aya.footballleague.di.component;

import android.app.Application;

import com.aya.footballleague.constants.AppController;
import com.aya.footballleague.di.builder.ActivityBuilder;
import com.aya.footballleague.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * created by Aya mohamed on 8/2/2018.
 */

@Singleton
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(AppController app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
