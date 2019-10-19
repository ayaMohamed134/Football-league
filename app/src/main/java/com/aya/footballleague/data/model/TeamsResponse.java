package com.aya.footballleague.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

@Entity(tableName = "teams")
public class TeamsResponse {

    @Expose
    @SerializedName("id")
    @ColumnInfo(name = "id")
    private String id;

    @Expose
    @SerializedName("count")
    @NotNull
    @ColumnInfo(name = "count")
    private String count;

    @Expose
    @SerializedName("competition")
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "competition")
    private LeaguesResponse.League competition;

    @Expose
    @SerializedName("teams")
    @NotNull
    @ColumnInfo(name = "teams")
    private ArrayList<Team> teams;

    public String getCount() {
        return count;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public TeamsResponse(String id, @NotNull String count, @NotNull LeaguesResponse.League competition, @NotNull ArrayList<Team> teams) {
        this.id = id;
        this.count = count;
        this.competition = competition;
        this.teams = teams;
    }

    public String getId() {
        return id;
    }

    @NotNull
    public LeaguesResponse.League getCompetition() {
        return competition;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCount(@NotNull String count) {
        this.count = count;
    }

    public void setCompetition(@NotNull LeaguesResponse.League competition) {
        this.competition = competition;
    }

    public void setTeams(@NotNull ArrayList<Team> teams) {
        this.teams = teams;
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
