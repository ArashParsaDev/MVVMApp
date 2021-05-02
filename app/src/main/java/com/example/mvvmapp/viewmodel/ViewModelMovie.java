package com.example.mvvmapp.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmapp.api.ApiClient;
import com.example.mvvmapp.model.Movie;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ViewModelMovie extends ViewModel {

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiClient apiClient;

    //MutableLiveData for prevent data loss
    private MutableLiveData<List<Movie>>  listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> getListMutableLiveData(){
        apiClient = new ApiClient();

        //Schedulers for prevent ui block
        compositeDisposable.add(apiClient.GET_LIST_MOVIE()
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<List<Movie>>() {
            @Override
            public void onSuccess(@NonNull List<Movie> movies) {
                listMutableLiveData.setValue(movies);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("Error Live Data : " , e.getMessage()+"");
            }
        }));



        return  listMutableLiveData;
    }


    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        super.onCleared();
    }
}

