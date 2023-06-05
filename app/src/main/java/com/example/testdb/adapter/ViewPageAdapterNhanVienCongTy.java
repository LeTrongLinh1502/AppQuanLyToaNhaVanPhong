package com.example.testdb.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.testdb.fragment.FragmentListNVCongTy;
import com.example.testdb.fragment.FragmentSearchNVCongTy;
import com.example.testdb.fragment.FragmentThongKeNVCongTy;

public class ViewPageAdapterNhanVienCongTy extends FragmentStatePagerAdapter {
    public ViewPageAdapterNhanVienCongTy(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentListNVCongTy();
            case 1:return new FragmentThongKeNVCongTy();
            case 2:return new FragmentSearchNVCongTy();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
