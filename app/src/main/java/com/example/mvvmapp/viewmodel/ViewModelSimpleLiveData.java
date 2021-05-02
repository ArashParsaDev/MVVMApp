package com.example.mvvmapp.viewmodel;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class ViewModelSimpleLiveData extends ViewModel {

    private MutableLiveData<String> USER_ID;

    public MutableLiveData<String> getUSER_ID(){
        if(USER_ID == null){
            USER_ID = new MutableLiveData<>();
        }
        return USER_ID;
    }

    public MutableLiveData<String> GET_RANDOM_USER_ID(){
        Random random = new Random();
        USER_ID.setValue("USER_ID : "+ random.nextInt(2021+1400));
        return  USER_ID;
    }

    public void onClick(View view){
        GET_RANDOM_USER_ID();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
