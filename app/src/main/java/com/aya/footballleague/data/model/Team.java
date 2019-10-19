package com.aya.footballleague.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Team {
    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("shortName")
    private String shortName;

    @Expose
    @SerializedName("crestUrl")
    private String crestUrl;

    @Expose
    @SerializedName("address")
    private String address;

    @Expose
    @SerializedName("website")
    private String website;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("squad")
    private ArrayList<Player> squad;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public String getAddress() {
        return address;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Player> getSquad() {
        return squad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Team)) {
            return false;
        }

        Team team = (Team) o;
        if (!id.equals(team.id)) {
            return false;
        }
        if (!name.equals(team.name)) {
            return false;
        }
        if (!crestUrl.equals(team.crestUrl)) {
            return false;
        }
        if (!website.equals(team.website)) {
            return false;
        }
        if (!address.equals(team.address)) {
            return false;
        }
        if (!email.equals(team.email)) {
            return false;
        }
        if (!squad.equals(team.squad)) {
            return false;
        }
        return shortName.equals(team.shortName);
    }
}
