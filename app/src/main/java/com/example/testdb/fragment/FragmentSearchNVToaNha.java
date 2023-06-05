package com.example.testdb.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.adapter.RecycleViewAdapterNVToaNha;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.NhanVienCongTy;
import com.example.testdb.model.NhanVienToaNha;

import java.sql.Connection;
import java.util.List;

public class FragmentSearchNVToaNha extends Fragment {
    private EditText edTim;
    private Button btnTim;
    private RecyclerView recyclerView;
    private RecycleViewAdapterNVToaNha adapter;
    private Controller db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_nv_toanha,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edTim=view.findViewById(R.id.edTim);
        btnTim=view.findViewById(R.id.btnSearch);
        recyclerView=view.findViewById(R.id.recyclerViewFragmentSearch);
        adapter=new RecycleViewAdapterNVToaNha();
        db=new Controller();
        List<NhanVienToaNha> list= db.getAllNVToaNha();
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edTim.getText().toString().equals("")){
                    List<NhanVienToaNha> list= db.getAllNVToaNha();
                    adapter.setList(list);
                }
                else{
                    List<NhanVienToaNha> list1=db.searchNVToaNhaByTenCMT(edTim.getText().toString().toLowerCase());
                    adapter.setList(list1);
                }

            }
        });
    }

}
