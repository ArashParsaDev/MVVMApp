package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ActivityPart4LiveDataBinding;
import com.example.mvvmapp.viewmodel.ViewModelSimpleLiveData;

public class Part4LiveDataActivity extends AppCompatActivity {


    ActivityPart4LiveDataBinding binding;
    Button btn_click;
    ViewModelSimpleLiveData viewModelSimpleLiveData;
    MutableLiveData<String> SHOW_USER_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_part4_live_data);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_part4_live_data);
        btn_click = binding.btnClick;
        viewModelSimpleLiveData = new ViewModelProvider(this).get(ViewModelSimpleLiveData.class);
        binding.setViewModelSimpleLiveData(viewModelSimpleLiveData);
        SHOW_USER_ID = viewModelSimpleLiveData.getUSER_ID();

        //Observe mesl gereftan response mimone
        SHOW_USER_ID.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String USER_RANDOM_ID) {
                btn_click.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Part4LiveDataActivity.this, USER_RANDOM_ID, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}