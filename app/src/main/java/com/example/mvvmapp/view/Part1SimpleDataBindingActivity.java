package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ActivityDataBindingSimplePart1Binding;
import com.example.mvvmapp.model.Users;

public class Part1SimpleDataBindingActivity extends AppCompatActivity {


    TextView tv_name;
    ActivityDataBindingSimplePart1Binding binding;
    Users users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_data_binding_simple_part1);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_simple_part1);
        users = new Users();
        users.setName("Arash Parsa");
        users.setEmail("arashparsa76@gmail.com");
        binding.setUsersInformation(users);
    }
}