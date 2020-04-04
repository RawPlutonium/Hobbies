package com.example.hobbies;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Hobby {
    public Hobby(String name, Integer hours){
        this.name  = name;
        this.hours = hours;
    }

    @PrimaryKey(autoGenerate = true)
    private int hobby_id;

    public int getHobby_id() {
        return hobby_id;
    }

    public void setHobby_id(int hobby_id) {
        this.hobby_id = hobby_id;
    }

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="hours")
    private Integer hours;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }
}
