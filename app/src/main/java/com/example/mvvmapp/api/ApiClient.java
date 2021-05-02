package com.example.mvvmapp.api;

import com.example.mvvmapp.model.Movie;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    String Base_url = "http://192.168.1.12/mvvm/";

    ApiInterface request;
    Retrofit retrofit;

    public ApiClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        request = retrofit.create(ApiInterface.class);

    }


    public Single<List<Movie>> GET_LIST_MOVIE(){


        return request.getListMovie();
    }


}
