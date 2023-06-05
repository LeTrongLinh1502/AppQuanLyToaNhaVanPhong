package com.example.testdb.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.testdb.fragment.FragmentListCongTy;
import com.example.testdb.fragment.FragmentListDichVu;
import com.example.testdb.fragment.FragmentSearchCongTy;
import com.example.testdb.fragment.FragmentSearchDichVu;
import com.example.testdb.fragment.FragmentThongKeCongTy;
import com.example.testdb.fragment.FragmentThongKeDichVu;

public class ViewPagerAdapterDichVu extends FragmentStatePagerAdapter {
    public ViewPagerAdapterDichVu(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentListDichVu();
            case 1:return new FragmentThongKeDichVu();
            case 2:return new FragmentSearchDichVu();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
