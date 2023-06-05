package com.example.testdb.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.testdb.fragment.FragmentListNVCongTy;
import com.example.testdb.fragment.FragmentListNVToaNha;
import com.example.testdb.fragment.FragmentSearchNVCongTy;
import com.example.testdb.fragment.FragmentSearchNVToaNha;
import com.example.testdb.fragment.FragmentThongKeNVCongTy;
import com.example.testdb.fragment.FragmentThongKeNVToaNha;

public class ViewPageAdapterNhanVienToaNha extends FragmentStatePagerAdapter {
    public ViewPageAdapterNhanVienToaNha(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentListNVToaNha();
            case 1:return new FragmentThongKeNVToaNha();
            case 2:return new FragmentSearchNVToaNha();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
