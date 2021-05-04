package com.example.mvvmapp.RoomDB;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


//sazo kar room az paeen b balast yani aval 1.column ha bad 2.table bad 3.database
//Entity bara sakht jadval

@Entity(tableName = "Information")
public class Information {

    @NonNull
    //@PrimaryKey(autoGenerate = true)
    // if its was int : @PrimaryKey(autoGenerate = true)
    @PrimaryKey
    @ColumnInfo(name = "id")
    private String id;

    @NonNull
    @ColumnInfo(name = "username")
    private String username;

    public Information(@NonNull String id, @NonNull String username) {
        this.id = id;
        this.username = username;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
