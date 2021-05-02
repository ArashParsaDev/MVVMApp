package com.example.mvvmapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvvmapp.R;

public class DetailFragment extends Fragment {


    public DetailFragment() {
        // Required empty public constructor
    }
    TextView tv_name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  =inflater.inflate(R.layout.fragment_detail, container, false);
        tv_name = view.findViewById(R.id.tv_frDetail_name);
        tv_name.setText(getArguments().getString("Key"));



        return view;
    }
}