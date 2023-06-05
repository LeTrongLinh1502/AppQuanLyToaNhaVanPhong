package com.example.testdb.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.testdb.fragment.FragmentListCongTy;
import com.example.testdb.fragment.FragmentSearchCongTy;
import com.example.testdb.fragment.FragmentThongKeCongTy;


public class ViewPagerAdapterCongTy extends FragmentStatePagerAdapter {
    public ViewPagerAdapterCongTy(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentListCongTy();
            case 1:return new FragmentThongKeCongTy();
            case 2:return new FragmentSearchCongTy();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
