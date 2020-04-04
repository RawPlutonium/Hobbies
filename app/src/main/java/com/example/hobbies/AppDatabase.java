package com.example.hobbies;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Hobby.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HobbyDao hobbyDao();

}
