package com.example.mvvmapp.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvvmapp.Interface.OnClickedItems;
import com.example.mvvmapp.R;
import com.example.mvvmapp.RoomDB.Information;
import com.example.mvvmapp.adapter.InformationAdapter;
import com.example.mvvmapp.viewmodel.ViewModelRoomDB;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Part9RoomDBActivity extends AppCompatActivity implements OnClickedItems {

    RecyclerView rv_part9;
    FloatingActionButton fab_add;
    TextView tv_showName;
    public static int REQUEST_CODE_INFORMATIONDB = 1;
    private static int REQUEST_CODE_INFORMATION_Update = 2 ;


    List<Information> listInformation = new ArrayList<>();
    InformationAdapter adapterInformation;
    ViewModelRoomDB viewModelRoomDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part9_room_d_b);

        viewModelRoomDB = new ViewModelProvider(this).get(ViewModelRoomDB.class);

        rv_part9 = findViewById(R.id.rv_part9);
        rv_part9.setHasFixedSize(true);
        rv_part9.setLayoutManager(new LinearLayoutManager(this));
        adapterInformation = new InformationAdapter(this,listInformation,this);
        rv_part9.setAdapter(adapterInformation);


        fab_add = findViewById(R.id.fab_part9_add);
        tv_showName = findViewById(R.id.tv_part9_showName);
        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Part9RoomDBActivity.this, AddInformationRoomDB.class);
                startActivityForResult(intent, REQUEST_CODE_INFORMATIONDB);
            }
        });



        viewModelRoomDB.getAllInformation().observe(this, new Observer<List<Information>>() {
            @Override
            public void onChanged(List<Information> informationList) {
                    adapterInformation.saveInformation(informationList);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_INFORMATIONDB && resultCode == RESULT_OK) {
            // Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();
            //how show it on a Textview from 2nd Activity to 1st one
            tv_showName.setText(data.getExtras().getString(AddInformationRoomDB.KEY_INFORMATION_SAVED));



            String rand_id= UUID.randomUUID().toString();
            Information information = new Information(rand_id,data.getStringExtra(AddInformationRoomDB.KEY_INFORMATION_SAVED));
            viewModelRoomDB.insertInformation(information);
            Toast.makeText(this, "Saved Successfully", Toast.LENGTH_SHORT).show();



        }else if(requestCode == REQUEST_CODE_INFORMATION_Update && resultCode ==RESULT_OK){
            String rand_id1= UUID.randomUUID().toString();
            Information information = new Information(rand_id1,data.getStringExtra(UpdateInformationRoomDB.REQUEST_CODE_UPDATE));
            viewModelRoomDB.updateInformation(information);


            Toast.makeText(this,data.getExtras().getString(UpdateInformationRoomDB.REQUEST_CODE_UPDATE) , Toast.LENGTH_SHORT).show();
            tv_showName.setText(data.getExtras().getString(UpdateInformationRoomDB.REQUEST_CODE_UPDATE));



        }
    }

    @Override
    public void onDelete(Information information) {
        viewModelRoomDB.deleteInformation(information);
        Log.d(String.valueOf(Part9RoomDBActivity.this),"success_delete");
    }

    @Override
    public void onUpdate(Information information) {
       /*
       //from adapter
       Intent intent = new Intent(new Intent(context, UpdateInformationRoomDB.class));
        intent.putExtra("name",data.get(Position).getUsername());
        ((Activity)context).startActivityForResult(intent,REQUEST_CODE_INFORMATION_Update);*/
       // Intent intent = new Intent(new Intent(Part9RoomDBActivity.this, UpdateInformationRoomDB.class));
      //  intent.putExtra("name",information.getUsername());
      //  intent.putExtra("id",information.getId());
        //startActivityForResult(intent,REQUEST_CODE_INFORMATION_Update);

      //  viewModelRoomDB.updateInformation(information);
        updateInformation(information);

    }


    public void updateInformation(Information information){
        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.activity_update_information_room_d_b,null);
        EditText edt_user =view.findViewById(R.id.edt_updateInformation);

        edt_user.setText(information.getUsername());

        edt_user.setSelectAllOnFocus(true);
        //edt focus & open keyboard
        edt_user.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(edt_user, InputMethodManager.SHOW_IMPLICIT);



        Button btn_updateInformation = view.findViewById(R.id.btn_updateInformation_ok);
        btn_updateInformation.setText("Update");

        btn_updateInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                information.setUsername(edt_user.getText().toString());
                viewModelRoomDB.updateInformation(information);
                Toast.makeText(Part9RoomDBActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();

            }
        });


        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();




    }


}