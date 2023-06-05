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
import com.example.testdb.model.DichVu;
import com.example.testdb.model.NhanVienCongTy;

public class UpdateDeleteDichVuActivity extends AppCompatActivity {
    private EditText edTenDV,edGia,edMaDV;
    private Spinner spLoaiDV;
    private Button btnDelete,btnCancel,btnUpdate;
    private DichVu dichVu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_dich_vu);
        initView();
        Intent intent=getIntent();
        dichVu= (DichVu) intent.getSerializableExtra("DichVu");
        edMaDV.setText(dichVu.getMaDV());
        edTenDV.setText(dichVu.getTenDV());
        edGia.setText(dichVu.getGia());
        for(int i=0;i<spLoaiDV.getCount();i++){
            if(dichVu.getLoaiDV().equals(spLoaiDV.getItemAtPosition(i))){
                spLoaiDV.setSelection(i);
                break;
            }
        }
        Controller db=new Controller();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maDV=edMaDV.getText().toString();
                String tenDV=edTenDV.getText().toString();
                String giaDV=edGia.getText().toString();
                String loaiDV=spLoaiDV.getSelectedItem().toString();
                DichVu dichVuUpdate= new DichVu(dichVu.getId(),maDV,tenDV,giaDV,loaiDV);
                db.updateDichVu(dichVuUpdate);
                startActivity(new Intent(UpdateDeleteDichVuActivity.this ,QuanLyDichVuActivity.class));
                finish();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteDichVu(dichVu.getId());
                startActivity(new Intent(UpdateDeleteDichVuActivity.this ,QuanLyDichVuActivity.class));
            }
        });
    }

    private void initView() {
        edTenDV=findViewById(R.id.edTenDV);
        edGia=findViewById(R.id.edGia);
        edMaDV=findViewById(R.id.edMa);
        btnDelete=findViewById(R.id.btnDelete);
        spLoaiDV=findViewById(R.id.spDichVu);
        btnCancel=findViewById(R.id.btnCancel);
        btnUpdate=findViewById(R.id.btnUpdate);
        spLoaiDV.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.LoaiDV)));
    }
}