package com.example.mvvmapp.RoomDB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//create the database
//create database similar to create Retrofit

@Database(entities = Information.class , version = 1 )
public abstract class InformationRoomDatabase extends RoomDatabase {

    //getter b dao
    public  abstract InformationDao getInformationDao();
    //jologiri az instance ziyad sakhtan dar class haye digar
    public static InformationRoomDatabase informationRoomDataBase;

    public static InformationRoomDatabase getInstance (Context context){

        if (informationRoomDataBase==null){

            informationRoomDataBase = Room.databaseBuilder(context.getApplicationContext() ,
                    InformationRoomDatabase.class , "INFORMATION_DB")
                    .build();

        }
        return informationRoomDataBase;
    }


}
