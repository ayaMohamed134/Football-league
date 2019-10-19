package com.aya.footballleague.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
        return shortName.equals(team.shortName);
    }
}
