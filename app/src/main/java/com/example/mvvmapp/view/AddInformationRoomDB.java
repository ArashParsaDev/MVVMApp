package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvvmapp.R;

public class AddInformationRoomDB extends AppCompatActivity {

    EditText edt_add;
    Button btn_add;
    public static String KEY_INFORMATION_SAVED="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information_room_d_b);

        setTitle("Insert Title");

        edt_add = findViewById(R.id.edt_addInformation_add);

        edt_add.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edt_add, InputMethodManager.SHOW_IMPLICIT);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        btn_add = findViewById(R.id.btn_addInformation_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent result =new Intent();

                if(TextUtils.isEmpty(edt_add.getText())){
                    setResult(RESULT_CANCELED,result);
                }else {
                    String username = edt_add.getText().toString();
                    result.putExtra(KEY_INFORMATION_SAVED,username);
                    setResult(RESULT_OK,result);
                }
                finish();
            }
        });
    }
}