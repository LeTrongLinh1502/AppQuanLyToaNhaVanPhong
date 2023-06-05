package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;
import com.example.testdb.model.DichVu;

import java.util.ArrayList;
import java.util.List;

public class AddDichVuActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edTenDV,edGia,edMaDV;
    private Spinner spLoaiDV;
    private Button btnAdd,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dich_vu);
        initView();
        btnCancel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    private void initView() {
        edTenDV=findViewById(R.id.edTenDV);
        edGia=findViewById(R.id.edGia);
        edMaDV=findViewById(R.id.edMa);
        btnAdd=findViewById(R.id.btnAdd);
        spLoaiDV=findViewById(R.id.spDichVu);
        btnCancel=findViewById(R.id.btnCancel);
        spLoaiDV.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.LoaiDV)));
    }

    @Override
    public void onClick(View view) {
        if(view==btnCancel){
            finish();
        }
        if (view==btnAdd){
            String tenDV=edTenDV.getText().toString();
            String maDV=edMaDV.getText().toString();
            String giaDV=edGia.getText().toString();
            String loaiDV=spLoaiDV.getSelectedItem().toString();
            DichVu dichVu=new DichVu(maDV,tenDV,giaDV,loaiDV);
            Controller db=new Controller();
            db.addDichVu(dichVu);
            startActivity(new Intent(AddDichVuActivity.this ,QuanLyDichVuActivity.class));
        }
    }
}