package com.example.covidtracker.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class CovidDataResponse {

    @SerializedName("success")
    boolean isSuccess;

    @SerializedName("data")
    public CovidData data;


    @SerializedName("lastRefreshed")
    public Date lastRefreshed;

    @SerializedName("lastOriginUpdate")
    public Date lastOriginUpdate;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public CovidData getData() {
        return data;
    }

    public void setData(CovidData data) {
        this.data = data;
    }

    public Date getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(Date lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public Date getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public void setLastOriginUpdate(Date lastOriginUpdate) {
        this.lastOriginUpdate = lastOriginUpdate;
    }

}
