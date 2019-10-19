package com.aya.footballleague.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TeamsResponse {

    @Expose
    @SerializedName("count")
    private String count;

    @Expose
    @SerializedName("teams")
    private ArrayList<Team> teams;

    public String getCount() {
        return count;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TeamsResponse)) {
            return false;
        }

        TeamsResponse objectResponse = (TeamsResponse) o;
        if (!teams.equals(objectResponse.teams)) {
            return false;
        }
        return count.equals(objectResponse.count);
    }

}
