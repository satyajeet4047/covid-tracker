package com.example.covidtracker.di.component;

import android.app.Application;

import com.example.covidtracker.CovidTrackerApplication;
import com.example.covidtracker.di.module.ActivityBindingModule;
import com.example.covidtracker.di.module.ApplicationModule;
import com.example.covidtracker.di.module.ContextModule;
import com.example.covidtracker.di.module.ViewModelFactoryModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ContextModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class, ViewModelFactoryModule.class, ApplicationModule.class})
public interface ApplicationComponent extends AndroidInjector<DaggerApplication> {

     void inject(CovidTrackerApplication application);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}