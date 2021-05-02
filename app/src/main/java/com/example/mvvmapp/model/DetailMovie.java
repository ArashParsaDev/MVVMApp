package com.example.mvvmapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class DetailMovie {

    private String name,genre,description,link_img;

    public DetailMovie(String name, String genre, String description, String link_img) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.link_img = link_img;
    }
    @BindingAdapter({"android:ImageView"})
    public static void  LoadImageView(ImageView ImageView , String link_img){
        Picasso.get().load(link_img).into(ImageView);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }
}
