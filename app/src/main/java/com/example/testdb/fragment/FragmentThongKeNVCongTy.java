package com.example.testdb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.adapter.RecycleViewAdapterNVCongTy;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.DichVu;
import com.example.testdb.model.NhanVienCongTy;

import java.util.ArrayList;
import java.util.List;

public class FragmentThongKeNVCongTy extends Fragment {
    private Button btnTK;
    private RecyclerView recyclerView;
    private RecycleViewAdapterNVCongTy adapter;
    private Controller db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_thongke_nv_congty,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnTK=view.findViewById(R.id.btnThongKe);
        recyclerView=view.findViewById(R.id.recyclerViewFragmentThongKe);
        db=new Controller();
        adapter=new RecycleViewAdapterNVCongTy();
        List<NhanVienCongTy> list= new ArrayList<>();
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        btnTK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<NhanVienCongTy> list= db.thongKeNVCongTy();
                adapter.setList(list);
            }
        });
    }
}
