package com.example.mvvmapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ItemRecyclerviewPart2Binding;
import com.example.mvvmapp.model.Users;

import java.util.List;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder> {


    Context context;
    List<Users> data;

    public AdapterRecyclerView(Context context, List<Users> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
       // View view = inflater.inflate(R.layout.item_recyclerview_part2,parent,false);
        ItemRecyclerviewPart2Binding binding = DataBindingUtil.inflate(inflater,R.layout.item_recyclerview_part2,parent,false);
        //return new MyViewHolder(view);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.setUsers(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ItemRecyclerviewPart2Binding binding;
        public MyViewHolder(@NonNull ItemRecyclerviewPart2Binding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
