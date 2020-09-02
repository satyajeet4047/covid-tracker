package com.example.covidtracker.data.model;

import com.google.gson.annotations.SerializedName;

public class Regional{
        @SerializedName("loc")
        public String loc;
        @SerializedName("confirmedCasesIndian")
        public int confirmedCasesIndian;
        @SerializedName("discharged")
        public int discharged;
        @SerializedName("deaths")
        public int deaths;
        @SerializedName("totalConfirmed")
        public int totalConfirmed;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public int getConfirmedCasesIndian() {
            return confirmedCasesIndian;
        }

        public void setConfirmedCasesIndian(int confirmedCasesIndian) {
            this.confirmedCasesIndian = confirmedCasesIndian;
        }

        public int getDischarged() {
            return discharged;
        }

        public void setDischarged(int discharged) {
            this.discharged = discharged;
        }

        public int getDeaths() {
            return deaths;
        }

        public void setDeaths(int deaths) {
            this.deaths = deaths;
        }

        public int getTotalConfirmed() {
            return totalConfirmed;
        }

        public void setTotalConfirmed(int totalConfirmed) {
            this.totalConfirmed = totalConfirmed;
        }
    }


