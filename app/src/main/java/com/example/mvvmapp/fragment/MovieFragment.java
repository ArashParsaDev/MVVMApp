package com.example.mvvmapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmapp.Interface.onClickMovieListener;
import com.example.mvvmapp.R;
import com.example.mvvmapp.adapter.MovieAdapter;
import com.example.mvvmapp.databinding.FragmentMovieBinding;
import com.example.mvvmapp.databinding.ItemMovieBinding;
import com.example.mvvmapp.model.Movie;
import com.example.mvvmapp.viewmodel.ViewModelMovie;

import java.util.List;

public class MovieFragment extends Fragment implements onClickMovieListener {

    public MovieFragment() {
        // Required empty public constructor
    }

    RecyclerView rv_itemMovie;
    MovieAdapter movieAdapter;
    FragmentMovieBinding binding;
    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_movie, container, false);
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_movie,container,false);
        rv_itemMovie = binding.rvFrMOvie;




        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelMovie viewModelMovie = new ViewModelProvider(getActivity()).get(ViewModelMovie.class);
        MutableLiveData<List<Movie>> listMutableLiveData = viewModelMovie.getListMutableLiveData();


        listMutableLiveData.observe(getActivity(), new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {

                rv_itemMovie.setLayoutManager(new GridLayoutManager(getActivity(),3));
                rv_itemMovie.setHasFixedSize(true);
                movieAdapter = new MovieAdapter(getActivity(),movies,MovieFragment.this::onClick);
                rv_itemMovie.setAdapter(movieAdapter);
            }
        });
    }

    @Override
    public void onClick(Movie movie) {

    Bundle bundle = new Bundle();
    bundle.putString("id",movie.getIdMovie());
    bundle.putString("description",movie.getDescriptionMovie());
    bundle.putString("genre",movie.getGenreMovie());
    bundle.putString("name",movie.getNameMovie());
    bundle.putString("link_img",movie.getLink_imgMovie());

        Navigation.findNavController(rv_itemMovie).navigate(R.id.action_movieFragment_to_detailMovieFragment,bundle);



    }
}