package com.aya.footballleague.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@Entity(tableName = "team")
public class Team {

    @Expose
    @NotNull
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private String id;

    @Expose
    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @Expose
    @SerializedName("shortName")
    @ColumnInfo(name = "shortName")
    private String shortName;

    @Expose
    @SerializedName("crestUrl")
    @ColumnInfo(name = "crestUrl")
    private String crestUrl;

    @Expose
    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    @Expose
    @SerializedName("website")
    @ColumnInfo(name = "website")
    private String website;

    @Expose
    @SerializedName("email")
    @ColumnInfo(name = "email")
    private String email;

    @Expose
    @SerializedName("squad")
    @ColumnInfo(name = "squad")
    private ArrayList<Player> squad;

    public Team(@NotNull String id, String name, String shortName, String crestUrl, String address, String website, String email, ArrayList<Player> squad) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.crestUrl = crestUrl;
        this.address = address;
        this.website = website;
        this.email = email;
        this.squad = squad;
    }

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


    public void setId(@NotNull String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setCrestUrl(String crestUrl) {
        this.crestUrl = crestUrl;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSquad(ArrayList<Player> squad) {
        this.squad = squad;
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
