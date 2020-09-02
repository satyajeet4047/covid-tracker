package com.example.covidtracker.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CovidData {

    @SerializedName("unofficial-summary")
    public List<UnofficialSummary> unofficial_summary;

    @SerializedName("regional")
    public List<Regional> regional;

    public List<UnofficialSummary> getUnofficial_summary() {
        return unofficial_summary;
    }

    public void setUnofficial_summary(List<UnofficialSummary> unofficial_summary) {
        this.unofficial_summary = unofficial_summary;
    }

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }
}
