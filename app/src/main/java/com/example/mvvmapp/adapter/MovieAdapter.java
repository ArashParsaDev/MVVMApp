package com.example.mvvmapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmapp.Interface.onClickMovieListener;
import com.example.mvvmapp.R;
import com.example.mvvmapp.databinding.ItemMovieBinding;
import com.example.mvvmapp.model.Movie;

import java.util.List;
import java.util.zip.Inflater;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    List<Movie> data;
    onClickMovieListener listener;

    public MovieAdapter(Context context, List<Movie> data,onClickMovieListener listener) {
        this.context = context;
        this.data = data;
        this.listener =listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // View view = LayoutInflater.from(context).inflate(R.layout.item_movie,parent,false);
        //return new MyViewHolder(view);

        LayoutInflater inflater = LayoutInflater.from(context);
        ItemMovieBinding binding = DataBindingUtil.inflate(inflater,R.layout.item_movie,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.setMovie(data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(data.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ItemMovieBinding binding;
        public MyViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
