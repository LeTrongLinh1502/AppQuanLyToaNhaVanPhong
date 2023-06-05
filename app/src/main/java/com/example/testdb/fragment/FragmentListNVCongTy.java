package com.example.testdb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.UpdateDeleteCongTyActivity;
import com.example.testdb.UpdateDeleteNVCongTyActivity;
import com.example.testdb.adapter.RecycleViewAdapterCongTy;
import com.example.testdb.adapter.RecycleViewAdapterNVCongTy;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;
import com.example.testdb.model.NhanVienCongTy;

import java.util.List;

public class FragmentListNVCongTy extends Fragment implements RecycleViewAdapterNVCongTy.ItemListener {
    private RecyclerView recycleView;
    private RecycleViewAdapterNVCongTy adapter;
    private Controller db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_nv_congty,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleView=view.findViewById(R.id.recycleView);
        adapter=new RecycleViewAdapterNVCongTy();
        db=new Controller();
        List<NhanVienCongTy> list= db.getAllNVCongTy();
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<NhanVienCongTy> list= db.getAllNVCongTy();
        adapter=new RecycleViewAdapterNVCongTy();
        adapter.setList(list);
    }

    @Override
    public void onItemClick(View view, int position) {
        NhanVienCongTy NVcongty= adapter.getItem(position);
        Intent intent=new Intent(getActivity(), UpdateDeleteNVCongTyActivity.class);
        intent.putExtra("NVcongty",NVcongty);
        startActivity(intent);
    }
}
