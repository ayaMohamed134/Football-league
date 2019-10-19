package com.aya.footballleague.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.aya.footballleague.data.local.db.dao.LeagueDao;
import com.aya.footballleague.data.local.db.dao.TeamDao;
import com.aya.footballleague.data.local.db.dao.TeamsDao;
import com.aya.footballleague.data.model.LeaguesResponse;
import com.aya.footballleague.data.model.Team;
import com.aya.footballleague.data.model.TeamsResponse;


/**
 * created by Aya mohamed on 8/2/2018.
 */

@Database(entities = {LeaguesResponse.League.class, TeamsResponse.class, Team.class}, version = 2, exportSchema = true)
@TypeConverters({Converters.class})
public abstract class AppRoomDatabase extends RoomDatabase {

    public abstract LeagueDao leagueDao();

    public abstract TeamsDao teamsDao();

    public abstract TeamDao teamDao();
}
