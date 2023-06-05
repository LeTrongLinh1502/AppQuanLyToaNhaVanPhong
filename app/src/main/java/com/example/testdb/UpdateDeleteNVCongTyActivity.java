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

import java.util.ArrayList;
import java.util.List;

public class UpdateDeleteNVCongTyActivity extends AppCompatActivity {
    private EditText edTenNV,edDiaChi,edCMT,edNgaySinh,edEmail;
    private Spinner spGioiTinh,spChucVu,spCongTy;
    private Button btnUpdate,btnCancel,btnDelete;
    private NhanVienCongTy Nvcongty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete_nv_congty);
        edTenNV=findViewById(R.id.edTenNV);
        edDiaChi=findViewById(R.id.edDiaChi);
        edCMT=findViewById(R.id.edCMT);
        edNgaySinh=findViewById(R.id.edNgaySinh);
        edEmail=findViewById(R.id.edEmail);
        spGioiTinh=findViewById(R.id.spGioiTinh);
        spChucVu=findViewById(R.id.spChucVu);
        spCongTy=findViewById(R.id.spCongTy);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnCancel=findViewById(R.id.btnCancel);
        ArrayList<String> tenCongTy=new ArrayList<>();
        Controller db=new Controller();
        List<CongTy> list=db.getAllCongTy();
        for(CongTy x: list){
            tenCongTy.add(x.getTenCTy());
        }
        spGioiTinh.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.GioiTinh)));
        spChucVu.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.ChucVuNVCongTy)));
        spCongTy.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spinner, tenCongTy));

        Intent intent=getIntent();
        Nvcongty= (NhanVienCongTy) intent.getSerializableExtra("NVcongty");
        edTenNV.setText(Nvcongty.getHoten());
        edDiaChi.setText(Nvcongty.getDiachi());
        edCMT.setText(Nvcongty.getCmt());
        edNgaySinh.setText(Nvcongty.getNgaysinh());
        edEmail.setText(Nvcongty.getEmail());
        for(int i=0;i<spGioiTinh.getCount();i++){
            if(Nvcongty.getGioitinh().equals(spGioiTinh.getItemAtPosition(i))){
                spGioiTinh.setSelection(i);
                break;
            }
        }
        for(int i=0;i<spChucVu.getCount();i++){
            if(Nvcongty.getChucvu().equals(spChucVu.getItemAtPosition(i))){
                spChucVu.setSelection(i);
                break;
            }
        }
        for(int i=0;i<spCongTy.getCount();i++){
            if(db.searchTenCongTyById(Nvcongty.getIdCongTy()).equals(spCongTy.getItemAtPosition(i))){
                spCongTy.setSelection(i);
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
                int iDcongty=db.searchIdCongTyByTen(spCongTy.getSelectedItem().toString());
                NhanVienCongTy NVcongTyToUpdate= new NhanVienCongTy(Nvcongty.getId(),diachi,hoten,gioitinh,cmt,ngaysinh,
                        email,chucvu,Nvcongty.getSolanravao(),iDcongty,Nvcongty.getSolanvao(),Nvcongty.getSolanra());
                db.updateNVCongTy(NVcongTyToUpdate);
                startActivity(new Intent(UpdateDeleteNVCongTyActivity.this ,QuanLyNhanVienCongTyActivity.class));
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.deleteNVCongTy(Nvcongty.getId());
                startActivity(new Intent(UpdateDeleteNVCongTyActivity.this ,QuanLyNhanVienCongTyActivity.class));
            }
        });
    }



}