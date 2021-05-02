package com.example.mvvmapp.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private List<String> nameFragment = new ArrayList<>();
    private List<Fragment> listFragment = new ArrayList<>();

    public  void setFragment(Fragment fragment, String name){
        listFragment.add(fragment);
        nameFragment.add(name);
    }


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return nameFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return nameFragment.get(position);
    }
}