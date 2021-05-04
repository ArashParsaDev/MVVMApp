package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.Observer;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;

import com.example.mvvmapp.R;
import com.example.mvvmapp.WorkManager.Work_Manager;

import java.util.concurrent.TimeUnit;

public class Part10WorkManagerActivity extends AppCompatActivity {

    WorkManager workManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part10_work_manager);

        getSupportActionBar().hide();

        workManager = WorkManager.getInstance(this);

        //baraye ijad mahdodiat
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        Data data = new Data.Builder().putString("title" , "Internet Connected").build();

        OneTimeWorkRequest oneTimeWorkRequest  = new OneTimeWorkRequest.Builder(Work_Manager.class)
                .setConstraints(constraints).setInputData(data).build();

        PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(Work_Manager.class , 15, TimeUnit.SECONDS)
                .setConstraints(constraints).setInputData(data).build();

        workManager.enqueue(periodicWorkRequest);
        workManager.getWorkInfoByIdLiveData(periodicWorkRequest.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {

                if (workInfo!=null){

                    if (workInfo.getState()== WorkInfo.State.RUNNING){


                    }
                }


            }
        });

    }
}