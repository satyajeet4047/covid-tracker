package com.example.covidtracker.data;

import com.example.covidtracker.data.ServiceApi;
import com.example.covidtracker.data.model.CovidDataResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class ServiceApiManager {

    final ServiceApi mServiceApi;

    @Inject
    public ServiceApiManager(ServiceApi serviceApi) {
        this.mServiceApi = serviceApi;
    }


    public Single<CovidDataResponse> fetchData(){
        return mServiceApi.fetchCovidData();
    }
}
