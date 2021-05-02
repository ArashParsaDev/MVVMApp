package com.example.mvvmapp.model;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class Users {

    private String name,email,link_img;

    public Users() {
    }

    public Users(String name, String email, String link_img) {
        this.name = name;
        this.email = email;
        this.link_img = link_img;
    }

    @BindingAdapter({"android:CircleImageView"})
    public static void  LoadCircleImageView(CircleImageView circleImageView , String link_img){
        Picasso.get().load(link_img).into(circleImageView);
    }


    public String getLink_img() {
        return link_img;
    }

    public void setLink_img(String link_img) {
        this.link_img = link_img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
