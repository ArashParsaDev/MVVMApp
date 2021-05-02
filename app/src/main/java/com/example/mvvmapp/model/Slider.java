package com.example.mvvmapp.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class Slider {


    private String name,link_img;

    public Slider(String name, String link_img) {
        this.name = name;
        this.link_img = link_img;
    }

    @BindingAdapter({"GET_LINK_IMAGE"})
    public static void  LoadImageView(ImageView ImageView , String link_img){
        Picasso.get().load(link_img).into(ImageView);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }
}
