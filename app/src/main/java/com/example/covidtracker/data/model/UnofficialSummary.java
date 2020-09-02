package com.example.covidtracker.data.model;

import com.google.gson.annotations.SerializedName;

public class UnofficialSummary {

    @SerializedName("total")
    public int total;
    @SerializedName("recovered")
    public int recovered;
    @SerializedName("deaths")
    public int deaths;
    @SerializedName("active")
    public int active;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
