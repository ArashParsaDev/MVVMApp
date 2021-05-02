package com.example.mvvmapp.view;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvvmapp.Interface.OnDeleteItems;
import com.example.mvvmapp.R;
import com.example.mvvmapp.RoomDB.Information;
import com.example.mvvmapp.viewmodel.ViewModelRoomDB;

public class UpdateInformationRoomDB extends AppCompatActivity{

    Button btn_ok;
    EditText edt_update;
    //Bundle bundle =new Bundle();

    public static String REQUEST_CODE_UPDATE ="arash";

    ViewModelRoomDB viewModelRoomDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information_room_d_b);
        edt_update = findViewById(R.id.edt_updateInformation);
        btn_ok = findViewById(R.id.btn_updateInformation_ok);

       // bundle = getIntent().getExtras();
       // edt_update.setText(bundle.getString("name"));
        Intent intent = getIntent();
        edt_update.setText(intent.getStringExtra("name"));
       // edt_update.setText(intent.getStringExtra("id"));


        setTitle("Update Title");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent();
                if(TextUtils.isEmpty(edt_update.getText())){
                    setResult(RESULT_CANCELED,result);
                }else {
                    String username =edt_update.getText().toString();
                    result.putExtra(REQUEST_CODE_UPDATE,username);
                    setResult(RESULT_OK,result);
                    Log.d("update_toast","update user is "+ username);

                }
                finish();


            }
        });
    }

}