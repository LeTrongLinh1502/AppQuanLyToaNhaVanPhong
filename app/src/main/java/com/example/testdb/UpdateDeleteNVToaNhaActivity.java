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
import com.example.testdb.model.NhanVienCongTy;
import com.example.testdb.model.NhanVienToaNha;

import java.util.ArrayList;
import java.util.List;

public class UpdateDeleteNVToaNhaActivity extends AppCompatActivity {
    private EditText edTenNV,edDiaChi,edCMT,edNgaySinh,edEmail,edLuong;
    private Spinner spGioiTinh,spChucVu,spVaiTro;
    private Button btnUpdate,btnCancel,btnDelete;
    private NhanVienToaNha nhanVienToaNha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_nv_toanha);
        edTenNV=findViewById(R.id.edTenNV);
        edDiaChi=findViewById(R.id.edDiaChi);
        edCMT=findViewById(R.id.edCMT);
        edNgaySinh=findViewById(R.id.edNgaySinh);
        edEmail=findViewById(R.id.edEmail);
        spGioiTinh=findViewById(R.id.spGioiTinh);
        spChucVu=findViewById(R.id.spChucVu);
        spVaiTro=findViewById(R.id.spVaiTro);
        edLuong=findViewById(R.id.edMucLuong);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnCancel=findViewById(R.id.btnCancel);
        spGioiTinh.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.GioiTinh)));
        spChucVu.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.ChucVuNVCongTy)));
        spVaiTro.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.VaiTro)));

        Intent intent=getIntent();
        nhanVienToaNha= (NhanVienToaNha) intent.getSerializableExtra("NVtoanha");
        edTenNV.setText(nhanVienToaNha.getHoten());
        edDiaChi.setText(nhanVienToaNha.getDiachi());
        edCMT.setText(nhanVienToaNha.getCmt());
        edNgaySinh.setText(nhanVienToaNha.getNgaysinh());
        edEmail.setText(nhanVienToaNha.getEmail());
        edLuong.setText(String.valueOf(nhanVienToaNha.getMucluong()));
        for(int i=0;i<spGioiTinh.getCount();i++){
            if(nhanVienToaNha.getGioitinh().equals(spGioiTinh.getItemAtPosition(i))){
                spGioiTinh.setSelection(i);
                break;
            }
        }
        for(int i=0;i<spChucVu.getCount();i++){
            if(nhanVienToaNha.getChucvu().equals(spChucVu.getItemAtPosition(i))){
                spChucVu.setSelection(i);
                break;
            }
        }
        for(int i=0;i<spVaiTro.getCount();i++){
            if(nhanVienToaNha.getVaitro().equals(spVaiTro.getItemAtPosition(i))){
                spVaiTro.setSelection(i);
                break;
            }
        }
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String diachi=edDiaChi.getText().toString();
                String hoten=edTenNV.getText().toString();
                String gioitinh=spGioiTinh.getSelectedItem().toString();
                String cmt=edCMT.getText().toString();
                String ngaysinh=edNgaySinh.getText().toString();
                String email=edEmail.getText().toString();
                String chucvu=spChucVu.getSelectedItem().toString();
                String vaitro=spVaiTro.getSelectedItem().toString();
                int mucluong=Integer.parseInt(edLuong.getText().toString());
                NhanVienToaNha nvtoanha= new NhanVienToaNha(diachi,hoten,gioitinh,cmt,ngaysinh,email,chucvu,vaitro,mucluong);
                Controller db= new Controller();
                db.addNVToaNha(nvtoanha);
                startActivity(new Intent(UpdateDeleteNVToaNhaActivity.this ,QuanLyNhanVienToaNhaActivity.class));
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Controller db= new Controller();
                db.deleteNVToaNha(nhanVienToaNha.getId());
                startActivity(new Intent(UpdateDeleteNVToaNhaActivity.this ,QuanLyNhanVienToaNhaActivity.class));
            }
        });
    }
}