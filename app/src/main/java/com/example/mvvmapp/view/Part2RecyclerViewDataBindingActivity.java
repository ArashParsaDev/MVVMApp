package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mvvmapp.R;
import com.example.mvvmapp.adapter.AdapterRecyclerView;
import com.example.mvvmapp.databinding.ActivityPart2RecyclerViewDataBindingBinding;
import com.example.mvvmapp.model.Users;

import java.util.ArrayList;
import java.util.List;

public class Part2RecyclerViewDataBindingActivity extends AppCompatActivity {

    ActivityPart2RecyclerViewDataBindingBinding binding;
    RecyclerView rv_user;
    AdapterRecyclerView adapterRecyclerView;
    List<Users> list_users = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_part2_recycler_view_data_binding);


        binding = DataBindingUtil.setContentView(this,R.layout.activity_part2_recycler_view_data_binding);
        rv_user = binding.rvUser;
        rv_user.setHasFixedSize(true);
        rv_user.setLayoutManager(new LinearLayoutManager(this));
        list_users.add(new Users("Natalie Portman","Natalie Portman@yahoo.com","http://t2.gstatic.com/images?q=tbn:ANd9GcSQYgDC8Vik8QkXEzq1_mrCoiGvILAkpPen-futoIZ9A51cloBHvFUNL3Stzn-v"));
        list_users.add(new Users("Nicole Kidman","NicoleKidman@yahoo.com","https://pyxis.nymag.com/v1/imgs/8a4/e6b/b6237f56f0428eedf85e117ef0c669de58-nicole-kidman.rvertical.w330.jpg"));
        list_users.add(new Users("Jason Statham","JasonStatham@yahoo.com","https://pyxis.nymag.com/v1/imgs/645/f7a/c6d24e1ab3732e23542c9b67590e9f1ab0-8-Jason-Statham.rsquare.w1200.jpg"));
        list_users.add(new Users("Scarlett Johansson","ScarlettJohansson@yahoo.com","https://s.france24.com/media/display/d3b3e99e-09bf-11e9-9890-005056a964fe/w:1280/p:4x3/scarlett%20johansson%20m.jpg"));
        list_users.add(new Users("Elizabeth Olsen","ElizabethOlsen@yahoo.com","https://img1.nickiswift.com/img/gallery/the-untold-truth-of-elizabeth-olsen/intro-1611166484.jpg"));
        list_users.add(new Users("Robert Downey, Jr.","RobertDowney@yahoo.com","http://www.gstatic.com/tv/thumb/persons/67369/67369_v9_bb.jpg"));
        list_users.add(new Users("Chris Hemsworth","ChrisHemsworth@yahoo.com","http://www.gstatic.com/tv/thumb/persons/528854/528854_v9_bb.jpg"));
        list_users.add(new Users("Angelina Jolie","AngelinaJolie@yahoo.com","http://www.gstatic.com/tv/thumb/persons/4950/4950_v9_bb.jpg"));
        list_users.add(new Users("Gal Gadot","GalGadot@yahoo.com","http://www.gstatic.com/tv/thumb/persons/532761/532761_v9_bc.jpg"));
        list_users.add(new Users("Chris Evans","ChrisEvans@yahoo.com","http://www.gstatic.com/tv/thumb/persons/173489/173489_v9_ba.jpg"));
        list_users.add(new Users("Margot Robbie","MargotRobbie@yahoo.com","http://www.gstatic.com/tv/thumb/persons/579067/579067_v9_bb.jpg"));
        list_users.add(new Users("Will Smith","WillSmith@yahoo.com","http://www.gstatic.com/tv/thumb/persons/1650/1650_v9_bb.jpg"));
        list_users.add(new Users("Leonardo DiCaprio","LeonardoDiCaprio@yahoo.com","http://www.gstatic.com/tv/thumb/persons/435/435_v9_bc.jpg"));
        adapterRecyclerView = new AdapterRecyclerView(this,list_users);
        rv_user.setAdapter(adapterRecyclerView);


    }
}