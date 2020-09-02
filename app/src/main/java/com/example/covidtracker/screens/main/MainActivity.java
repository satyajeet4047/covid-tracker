package com.example.covidtracker.screens.main;


import android.os.Bundle;

import com.example.covidtracker.R;
import com.example.covidtracker.screens.base.BaseActivity;
import com.example.covidtracker.screens.fragment.DashboardFragment;

public class MainActivity extends BaseActivity<MainActivityViewModel> {

    @Override
    public MainActivityViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.screenContainer, new DashboardFragment()).commit();
    }
}
