package com.example.covidtracker.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.covidtracker.di.util.ViewModelKey;
import com.example.covidtracker.screens.Factory.ViewModelFactory;
import com.example.covidtracker.screens.fragment.DashboardViewModel;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelFactoryModule {



    @Binds
    @IntoMap
    @ViewModelKey(DashboardViewModel.class)
    abstract ViewModel bindDetailsViewModel(DashboardViewModel dashboardViewModel);



    @Singleton
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
