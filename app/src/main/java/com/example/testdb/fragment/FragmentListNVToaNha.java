package com.example.testdb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.UpdateDeleteNVCongTyActivity;
import com.example.testdb.UpdateDeleteNVToaNhaActivity;
import com.example.testdb.adapter.RecycleViewAdapterNVCongTy;
import com.example.testdb.adapter.RecycleViewAdapterNVToaNha;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.NhanVienCongTy;
import com.example.testdb.model.NhanVienToaNha;

import java.util.List;

public class FragmentListNVToaNha extends Fragment implements RecycleViewAdapterNVToaNha.ItemListener{
    private RecyclerView recyclerView;
    private RecycleViewAdapterNVToaNha adapter;
    private Controller db;
    private TextView tvTong;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_nv_toanha,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycleView);
        tvTong=view.findViewById(R.id.tvTong);
        adapter=new RecycleViewAdapterNVToaNha();
        db=new Controller();
        List<NhanVienToaNha> list= db.getAllNVToaNha();
        tvTong.setText("Số nhân viên tòa nhà: "+list.size());
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<NhanVienToaNha> list= db.getAllNVToaNha();
        adapter=new RecycleViewAdapterNVToaNha();
        adapter.setList(list);
    }

    @Override
    public void onItemClick(View view, int position) {
        NhanVienToaNha NVtoanha= adapter.getItem(position);
        Intent intent=new Intent(getActivity(), UpdateDeleteNVToaNhaActivity.class);
        intent.putExtra("NVtoanha",NVtoanha);
        startActivity(intent);
    }
}
