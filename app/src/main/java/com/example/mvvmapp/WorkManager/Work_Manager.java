package com.example.mvvmapp.WorkManager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.mvvmapp.R;

public class Work_Manager extends Worker {

    private String CHANNEL_ID = "";


    public Work_Manager(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        Data data = getInputData();
        NOTIFICATION_SHOW(data.getString("title") , "Welcome To MvvmApp");

        return Result.success();
    }

    public void NOTIFICATION_SHOW (String title , String description){

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT>=26){

            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID , "Toplearn.com" , NotificationManager.IMPORTANCE_DEFAULT);
            notificationManager.createNotificationChannel(notificationChannel);

        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext() , CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(description)
                .setSmallIcon(R.drawable.ic_baseline_network_check_24);

        notificationManager.notify(1 , builder.build());

    }

}
