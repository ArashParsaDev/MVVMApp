package com.example.mvvmapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiStack {

    String BASE_URL = "https://api.stackexchange.com/2.2/";
    Retrofit retrofit;
    static ApiStack apiStack;



    public  ApiStack(){
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

    }



    public static ApiStack getInstance(){
        if(apiStack == null){
            apiStack = new ApiStack();
        }
        return apiStack;
    }



    public ApiInterface getApiStack(){
        return  retrofit.create(ApiInterface.class);
    }
}
