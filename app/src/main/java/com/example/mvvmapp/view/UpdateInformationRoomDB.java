package com.example.mvvmapp.view;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvvmapp.Interface.OnClickedItems;
import com.example.mvvmapp.R;
import com.example.mvvmapp.RoomDB.Information;
import com.example.mvvmapp.adapter.InformationAdapter;
import com.example.mvvmapp.viewmodel.ViewModelRoomDB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UpdateInformationRoomDB extends AppCompatActivity  {

    Button btn_ok;
    EditText edt_update;
    //Bundle bundle =new Bundle();

    public static String REQUEST_CODE_UPDATE ="";


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information_room_d_b);
        edt_update = findViewById(R.id.edt_updateInformation);
        btn_ok = findViewById(R.id.btn_updateInformation_ok);
        String username =edt_update.getText().toString();



        // bundle = getIntent().getExtras();
       // edt_update.setText(bundle.getString("name"));
        Intent intent = getIntent();
        edt_update.setText(intent.getStringExtra("name"));
        edt_update.setSelectAllOnFocus(true);
        //edt focus & open keyboard
        edt_update.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edt_update, InputMethodManager.SHOW_IMPLICIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        setTitle("Update Title");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent result = new Intent();
                if(TextUtils.isEmpty(edt_update.getText())){
                    setResult(RESULT_CANCELED,result);
                }else {
                    String username =edt_update.getText().toString();
                    result.putExtra(String.valueOf(REQUEST_CODE_UPDATE),username);
                    setResult(RESULT_OK,result);
                }
                finish();
            }
        });
    }
}