package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Connection;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;

public class AddCongTyActivity extends AppCompatActivity {
    private EditText tvTenCT,tvDiachi,tvEmail,tvSĐT,tvSoNV;
    private Button btnAdd,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cong_ty);
        initView();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten=tvTenCT.getText().toString();
                String diachi=tvDiachi.getText().toString();
                String email=tvEmail.getText().toString();
                String soDT=tvSĐT.getText().toString();
                int soNV=Integer.parseInt(tvSoNV.getText().toString());
                CongTy congTyToAdd= new CongTy(ten,diachi,email,soDT,soNV);
                Controller controller=new Controller();
                controller.addCongTy(congTyToAdd);
                startActivity(new Intent(AddCongTyActivity.this ,QuanLyCongTyActivity.class));
            }
        });
    }

    private void initView() {
        tvTenCT=findViewById(R.id.tvTenCT);
        tvDiachi=findViewById(R.id.tvDiaChi);
        tvEmail=findViewById(R.id.tvEmail);
        tvSĐT=findViewById(R.id.tvSDT);
        tvSoNV=findViewById(R.id.tvSoNV);
        btnAdd=findViewById(R.id.btnAdd);
        btnCancel=findViewById(R.id.btnCancel);

    }
}