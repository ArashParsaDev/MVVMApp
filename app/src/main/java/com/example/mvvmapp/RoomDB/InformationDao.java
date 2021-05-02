package com.example.mvvmapp.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//for addding Queries and actions
//for doing CRUD operations :Create , Read, Update , Delete
@Dao
public interface InformationDao {

    @Query("SELECT * FROM information")
    LiveData<List<Information>> getAllInformation();

    @Query("SELECT * FROM information WHERE id =:information_id")
    LiveData<List<Information>> getInformationById(String information_id);

    @Insert
    void insertInformation(Information information);


    @Update
    void updateInformation(Information information);

    @Delete
    void deleteInformation(Information information);

}
