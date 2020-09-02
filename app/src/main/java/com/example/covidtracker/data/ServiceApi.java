package com.example.covidtracker.data;

import com.example.covidtracker.data.model.CovidDataResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("latest")
    Single<CovidDataResponse> fetchCovidData();
}
