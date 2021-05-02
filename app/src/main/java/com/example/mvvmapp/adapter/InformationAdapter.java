package com.example.mvvmapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmapp.Interface.OnDeleteItems;
import com.example.mvvmapp.R;
import com.example.mvvmapp.RoomDB.Information;
import com.example.mvvmapp.view.UpdateInformationRoomDB;

import java.util.List;
import java.util.UUID;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.MyViewHolder> {

    Context context;
    List<Information> data;
    OnDeleteItems listener;
    private static int REQUEST_CODE_INFORMATION_Update = 2 ;



    public InformationAdapter(Context context, List<Information> data,OnDeleteItems listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_infomation,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        if (data != null) {
            holder.setInformation(data.get(position).getUsername(),position);
            holder.setListener();
        }

    }

    public void  saveInformation(List<Information> information){
        data=information;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_information;
        int Position = getAdapterPosition();
        ImageView iv_delete;
        ImageView iv_update;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_information= itemView.findViewById(R.id.tv_item_addInformation);
            iv_delete= itemView.findViewById(R.id.iv_itemInformation_delete);
            iv_update= itemView.findViewById(R.id.iv_itemInformation_update);
        }

        public void setInformation(String username,int position){
            tv_information.setText(username);
            Position = position;
        }


        public  void setListener(){

            iv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                listener.onDelete(data.get(Position));
                }
            });

            iv_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onUpdate(data.get(Position));
                }
            });
        }
    }
}
