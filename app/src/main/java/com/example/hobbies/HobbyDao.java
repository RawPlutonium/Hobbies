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

    @Query("SELECT * FROM hobby WHERE hobby_id=:id")
    Hobby getHobby(int id);

    @Query("UPDATE Hobby SET name = :name, hours = :hours WHERE hobby_id=:id")
    void updateHobby(String name, Integer hours, int id);
}
