package com.example.covidtracker.screens.fragment;

import com.example.covidtracker.screens.fragment.DashboardFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsBindingModule {


    @ContributesAndroidInjector
    abstract DashboardFragment provideDashboardFragment();
}
