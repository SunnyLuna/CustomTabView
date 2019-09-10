package com.decard.customtabview;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragmentList;
    private FragmentManager fm;

    public TabPagerAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment> fragmentList) {
        super(fm, behavior);
        this.fm = fm;
        this.fragmentList = fragmentList;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
