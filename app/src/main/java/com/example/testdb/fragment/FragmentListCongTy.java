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
import com.example.testdb.UpdateDeleteCongTyActivity;
import com.example.testdb.adapter.RecycleViewAdapterCongTy;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;

import java.util.List;

public class FragmentListCongTy extends Fragment implements RecycleViewAdapterCongTy.ItemListener{
    private RecyclerView recycleView;
    private RecycleViewAdapterCongTy adapter;
    private Controller db;
    private TextView tvTong;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_congty,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycleView=view.findViewById(R.id.recycleView);
        tvTong=view.findViewById(R.id.tvTong);
        adapter=new RecycleViewAdapterCongTy();
        db=new Controller();
        List<CongTy> list= db.getAllCongTy();
        tvTong.setText("Số công ty: "+list.size());
//        Toast.makeText(getContext(), list.size()+"", Toast.LENGTH_SHORT).show();
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
        adapter.setItemListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<CongTy> list= db.getAllCongTy();
        adapter=new RecycleViewAdapterCongTy();
        adapter.setList(list);
    }

    @Override
    public void onItemClick(View view, int position) {
        CongTy congty= adapter.getItem(position);
        Intent intent=new Intent(getActivity(), UpdateDeleteCongTyActivity.class);
        intent.putExtra("congty",congty);
        startActivity(intent);
    }
}
