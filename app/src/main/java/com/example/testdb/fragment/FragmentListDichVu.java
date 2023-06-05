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
import com.example.testdb.UpdateDeleteDichVuActivity;
import com.example.testdb.UpdateDeleteNVCongTyActivity;
import com.example.testdb.adapter.RecycleViewAdapterDichVu;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.DichVu;

import java.util.List;

public class FragmentListDichVu extends Fragment implements RecycleViewAdapterDichVu.ItemListener{
    private RecyclerView recycleView;
    private RecycleViewAdapterDichVu adapter;
    private Controller db;
    private TextView tvTong;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_dichvu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleView=view.findViewById(R.id.recycleView);
        tvTong=view.findViewById(R.id.tvTong);
        adapter=new RecycleViewAdapterDichVu();
        db=new Controller();
        List<DichVu> list=db.getAllDichVu();
        tvTong.setText("Số dịch vụ: "+list.size());
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<DichVu> list=db.getAllDichVu();
        adapter=new RecycleViewAdapterDichVu();
        tvTong.setText("Số dịch vụ: "+list.size());
        adapter.setList(list);
    }

    @Override
    public void onItemClick(View view, int position) {
        DichVu dichVu=adapter.getItem(position);
        Intent intent=new Intent(getActivity(), UpdateDeleteDichVuActivity.class);
        intent.putExtra("DichVu",dichVu);
        startActivity(intent);
    }
}
