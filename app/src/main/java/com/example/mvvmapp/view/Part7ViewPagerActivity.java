package com.example.mvvmapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.View;

import com.example.mvvmapp.R;
import com.example.mvvmapp.adapter.SliderAdapter;
import com.example.mvvmapp.adapter.ViewPagerAdapter;
import com.example.mvvmapp.databinding.ActivityPart7ViewPagerBinding;
import com.example.mvvmapp.fragment.HomeFragment;
import com.example.mvvmapp.fragment.MovieFragment;
import com.example.mvvmapp.model.Slider;
import com.example.mvvmapp.model.Users;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Part7ViewPagerActivity extends AppCompatActivity {

    ActivityPart7ViewPagerBinding binding;
    static SliderAdapter adapter;
    //how add fragments to Viewpager : add class ViewPagerAdapter and done
   // static ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_part7_view_pager);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_part7_view_pager);
        binding.setViewPagerz(this);
        binding.setFragmentManager(getSupportFragmentManager());
        //adapter = new ViewPagerAdapter(getSupportFragmentManager());

    }


    @BindingAdapter("SET_VIEWPAGER")
    //to parantez on laye k mikhaym piyade konim
    public static void setViewPager(ViewPager viewPager, Part7ViewPagerActivity context) {
        List<Slider> listSlider = new ArrayList<>();
        listSlider.add(new Slider("Elizabeth Olsen","https://img1.nickiswift.com/img/gallery/the-untold-truth-of-elizabeth-olsen/intro-1611166484.jpg"));
        listSlider.add(new Slider("Robert Downey, Jr.","http://www.gstatic.com/tv/thumb/persons/67369/67369_v9_bb.jpg"));
        listSlider.add(new Slider("Chris Hemsworth","http://www.gstatic.com/tv/thumb/persons/528854/528854_v9_bb.jpg"));

        adapter = new SliderAdapter(listSlider);
        viewPager.setAdapter(adapter);

         /*
        adapter.setFragment(new HomeFragment() , "Home");
        adapter.setFragment(new MovieFragment() , "Movie");
        viewPager.setAdapter(adapter);
*/
    }

    @BindingAdapter("SET_TABLAYOUT")
    public static void setTabLayout(TabLayout tabLayout, ViewPager viewPager) {
        tabLayout.setupWithViewPager(viewPager, true);
    }


}
