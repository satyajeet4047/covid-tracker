package com.example.covidtracker;

import com.example.covidtracker.di.component.ApplicationComponent;
import com.example.covidtracker.di.component.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class CovidTrackerApplication extends DaggerApplication {

    private static CovidTrackerApplication instance;


    public static synchronized CovidTrackerApplication getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        applicationComponent.inject(this);
        return applicationComponent;

    }
}
