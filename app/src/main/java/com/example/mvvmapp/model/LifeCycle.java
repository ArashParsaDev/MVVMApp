package com.example.mvvmapp.model;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifeCycle implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void  ON_CREATE(){
        Log.d("ON_CREATE","ON_CREATE_MVVM");
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void  ON_DESTROY(){
        Log.d("ON_DESTROY","ON_DESTROY_MVVM");
    }
}
