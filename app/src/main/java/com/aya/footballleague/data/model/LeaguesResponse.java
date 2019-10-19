package com.aya.footballleague.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

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

    @Entity(tableName = "league")
    public static class League {


        @Expose
        @NotNull
        @PrimaryKey
        @SerializedName("id")
        @ColumnInfo(name = "id")
        private String id;

        @Expose
        @NotNull
        @SerializedName("name")
        @ColumnInfo(name = "name")
        private String name;

        @Expose
        @NotNull
        @SerializedName("numberOfAvailableSeasons")
        @ColumnInfo(name = "numberOfAvailableSeasons")
        private String numberOfAvailableSeasons;

        public League(@NotNull String id, @NotNull String name, @NotNull String numberOfAvailableSeasons) {
            this.id = id;
            this.name = name;
            this.numberOfAvailableSeasons = numberOfAvailableSeasons;
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

        public void setId(@NotNull String id) {
            this.id = id;
        }

        public void setName(@NotNull String name) {
            this.name = name;
        }

        public void setNumberOfAvailableSeasons(@NotNull String numberOfAvailableSeasons) {
            this.numberOfAvailableSeasons = numberOfAvailableSeasons;
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
