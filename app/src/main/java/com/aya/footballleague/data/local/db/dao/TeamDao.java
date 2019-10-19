package com.aya.footballleague.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aya.footballleague.data.model.Team;

@Dao
public interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Team team);

    @Query("SELECT * FROM team WHERE id = :team_id")
    Team loadTeam(String team_id);
}
