package com.aya.footballleague.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aya.footballleague.data.model.LeaguesResponse;

import java.util.List;

@Dao
public interface LeagueDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LeaguesResponse.League league);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<LeaguesResponse.League> leagues);

    @Query("SELECT * FROM league")
    List<LeaguesResponse.League> loadAll();
}
