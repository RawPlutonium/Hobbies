package com.example.hobbies;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HobbyDao {
    @Query("SELECT * FROM hobby")
    List<Hobby> getAllHobbies();

    @Insert
    void insertAll(Hobby... hobbies);
}
