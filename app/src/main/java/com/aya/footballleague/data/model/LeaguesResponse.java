package com.aya.footballleague.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeaguesResponse {

    @Expose
    @SerializedName("count")
    private String count;

    @Expose
    @SerializedName("competitions")
    private ArrayList<League> competitions;

    public String getCount() {
        return count;
    }

    public ArrayList<League> getCompetitions() {
        return competitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LeaguesResponse)) {
            return false;
        }

        LeaguesResponse objectResponse = (LeaguesResponse) o;
        if (!competitions.equals(objectResponse.competitions)) {
            return false;
        }
        return count.equals(objectResponse.count);
    }

    public static class League {

        private static final String AREAS = "areas";

        @Expose
        @SerializedName("id")
        private String id;

        @Expose
        @SerializedName("name")
        private String name;

        @Expose
        @SerializedName("numberOfAvailableSeasons")
        private String numberOfAvailableSeasons;

        public static Map<String, String> sendAreasValues(String areasValue) {
            Map<String, String> map = new HashMap<>();
            map.put(AREAS, areasValue);
            return map;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getNumberOfAvailableSeasons() {
            return numberOfAvailableSeasons;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof League)) {
                return false;
            }

            League league = (League) o;
            if (!id.equals(league.id)) {
                return false;
            }
            if (!name.equals(league.name)) {
                return false;
            }
            return numberOfAvailableSeasons.equals(league.numberOfAvailableSeasons);
        }
    }

}
