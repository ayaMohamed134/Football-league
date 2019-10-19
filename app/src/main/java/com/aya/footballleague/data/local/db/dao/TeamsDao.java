package com.aya.footballleague.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aya.footballleague.data.model.TeamsResponse;

import java.util.List;

@Dao
public interface TeamsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TeamsResponse teamsResponse);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TeamsResponse> teamsResponses);

    @Query("SELECT * FROM teams")
    List<TeamsResponse> loadAll();
}
