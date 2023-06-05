package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;

public class UpdateDeleteCongTyActivity extends AppCompatActivity {
    private EditText tvTenCT,tvDiachi,tvEmail,tvSĐT,tvSoNV;
    private Button btnDelete,btnCancel,btnUpdate;
    private CongTy congTy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_cong_ty);
        initView();
        Intent intent = getIntent();
        congTy= (CongTy) intent.getSerializableExtra("congty");
        tvTenCT.setText(congTy.getTenCTy());
        tvDiachi.setText(congTy.getDiachi());
        tvEmail.setText(congTy.getEmail());
        tvSĐT.setText(congTy.getSđt());
        tvSoNV.setText(String.valueOf(congTy.getSoNV()));
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten=tvTenCT.getText().toString();
                String diachi=tvDiachi.getText().toString();
                String email=tvEmail.getText().toString();
                String soDT=tvSĐT.getText().toString();
                int soNV=Integer.parseInt(tvSoNV.getText().toString());
                CongTy congTyToUpdate= new CongTy(congTy.getId(),ten,diachi,email,soDT,soNV);
                Controller controller=new Controller();
                controller.updateCongTy(congTyToUpdate);
                startActivity(new Intent(UpdateDeleteCongTyActivity.this ,QuanLyCongTyActivity.class));
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Controller controller=new Controller();
                controller.deleteCongTy(congTy.getId());
                startActivity(new Intent(UpdateDeleteCongTyActivity.this ,QuanLyCongTyActivity.class));
            }
        });

    }

    private void initView() {
        tvTenCT=findViewById(R.id.tvTenCT);
        tvDiachi=findViewById(R.id.tvDiaChi);
        tvEmail=findViewById(R.id.tvEmail);
        tvSĐT=findViewById(R.id.tvSDT);
        tvSoNV=findViewById(R.id.tvSoNV);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnCancel=findViewById(R.id.btnCancel);
        btnDelete=findViewById(R.id.btnDelete);
    }
}