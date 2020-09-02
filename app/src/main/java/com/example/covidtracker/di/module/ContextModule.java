package com.example.covidtracker.di.module;

import android.app.Application;
import android.content.Context;

import com.example.covidtracker.CovidTrackerApplication;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ContextModule {

    @Binds
    abstract Context bindApplicationContext(Application application);
}
