package com.example.mvvmapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Movie {
    @SerializedName("id")
    private String idMovie;

    @SerializedName("name")
    private String nameMovie;

    @SerializedName("description")
    private String descriptionMovie;

    @SerializedName("link_img")
    private String link_imgMovie;

    @SerializedName("genre")
    private String genreMovie;


    public Movie() {
    }


    @BindingAdapter({"android:ImageView"})
    public static void  LoadImageView(ImageView ImageView , String link_img){
        Picasso.get().load(link_img).into(ImageView);
    }

    public String getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(String idMovie) {
        this.idMovie = idMovie;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getDescriptionMovie() {
        return descriptionMovie;
    }

    public void setDescriptionMovie(String descriptionMovie) {
        this.descriptionMovie = descriptionMovie;
    }

    public String getLink_imgMovie() {
        return link_imgMovie;
    }

    public void setLink_imgMovie(String link_imgMovie) {
        this.link_imgMovie = link_imgMovie;
    }

    public String getGenreMovie() {
        return genreMovie;
    }

    public void setGenreMovie(String genreMovie) {
        this.genreMovie = genreMovie;
    }
}
