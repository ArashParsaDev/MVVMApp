package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.os.Bundle;

import com.example.mvvmapp.R;
import com.example.mvvmapp.model.LifeCycle;

public class Part3LifeCycleActivity extends AppCompatActivity {

    LifeCycle lifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part3_life_cycle);

        lifecycle = new LifeCycle();
        lifecycle.ON_CREATE();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifecycle.ON_DESTROY();
    }
}