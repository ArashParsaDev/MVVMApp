package com.example.mvvmapp.api;

import com.example.mvvmapp.model.ApiStackResponse;
import com.example.mvvmapp.model.Movie;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    //Call<List<Movie>>

    @GET("getMovieSeries.php")
    Single<List<Movie>> getListMovie();


    @GET("answers")
    Call<ApiStackResponse> getApiStackResponse(
            @Query("page")int page,
            @Query("pagesize")int pagesize,
            @Query("site") int site
    );

}
