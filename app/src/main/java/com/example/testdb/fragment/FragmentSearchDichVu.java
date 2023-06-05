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
import com.example.testdb.adapter.RecycleViewAdapterDichVu;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.DichVu;
import com.example.testdb.model.NhanVienCongTy;

import java.util.List;

public class FragmentSearchDichVu extends Fragment {
    private EditText edTim;
    private Button btnTim;
    private RecyclerView recyclerView;
    private RecycleViewAdapterDichVu adapter;
    private Controller db;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_dichvu,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edTim=view.findViewById(R.id.edTim);
        btnTim=view.findViewById(R.id.btnSearch);
        recyclerView=view.findViewById(R.id.recyclerViewFragmentSearch);
        adapter=new RecycleViewAdapterDichVu();
        db=new Controller();
        List<DichVu> list=db.getAllDichVu();
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        btnTim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edTim.getText().toString().equals("")){
                    List<DichVu> list= db.getAllDichVu();
                    adapter.setList(list);
                }
                else{
                    List<DichVu> list1=db.searchDichVuByTen(edTim.getText().toString().toLowerCase());
                    adapter.setList(list1);
                }

            }
        });
    }
}
