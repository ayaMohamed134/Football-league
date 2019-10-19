package com.aya.footballleague.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aya.footballleague.data.model.Team;

import java.util.List;

@Dao
public interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Team team);

    @Query("SELECT * FROM team WHERE id = :team_id")
    Team loadTeam(String team_id);

    @Query("UPDATE team SET is_fav = :is_fav WHERE id = :team_id")
    void update(String is_fav, String team_id);

    @Query("SELECT * FROM team WHERE is_fav = 1")
    List<Team> loadFavTeams();
}
