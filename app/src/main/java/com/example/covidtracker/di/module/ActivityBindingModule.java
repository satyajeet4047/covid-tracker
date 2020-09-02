package com.example.covidtracker.di.module;

import com.example.covidtracker.screens.fragment.FragmentsBindingModule;
import com.example.covidtracker.screens.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {


    @ContributesAndroidInjector(modules = FragmentsBindingModule.class)
    abstract MainActivity bindMainActivity();
}
