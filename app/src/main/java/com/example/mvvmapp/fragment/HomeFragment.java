package com.example.mvvmapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mvvmapp.R;

public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }
     Button btn_go;


    //onCreateView : view sakhte mishe
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_go = view.findViewById(R.id.btn_FrHome_go);



        return  view;
    }

    //onViewCreated : estefade mikoni az view
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections navDirections = HomeFragmentDirections.actionHomeFragmentToDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putString("Key","Arash Parsa - MVVM");
                //moarefi view(btn) b nav
                Navigation.findNavController(btn_go).navigate(R.id.action_homeFragment_to_detailFragment,bundle);
            }
        });
    }
}