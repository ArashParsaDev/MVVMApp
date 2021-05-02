package com.example.mvvmapp.Interface;

import android.content.Intent;

import com.example.mvvmapp.RoomDB.Information;

public interface OnDeleteItems {

    void onDelete(Information information);
    void onUpdate(Information information);
}
