package com.aya.footballleague.data.local.db;

import androidx.room.TypeConverter;

import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Player;
import com.aya.footballleague.data.model.Team;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {
    @TypeConverter
    public static ArrayList<Team> fromString(String value) {
        Type listType = new TypeToken<ArrayList<Team>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Team> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static ArrayList<Player> fromPString(String value) {
        Type listType = new TypeToken<ArrayList<Player>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayPList(ArrayList<Player> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    @TypeConverter
    public static LeaguesResponse.League fromStringToObj(String value) {
        Type objType = new TypeToken<LeaguesResponse.League>() {}.getType();
        return new Gson().fromJson(value, objType);
    }

    @TypeConverter
    public static String fromObj(LeaguesResponse.League league) {
        Gson gson = new Gson();
        String json = gson.toJson(league);
        return json;
    }
}
