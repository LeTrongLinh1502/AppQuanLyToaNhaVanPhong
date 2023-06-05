package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdb.controller.Controller;
import com.example.testdb.model.HopDong;

import java.util.Calendar;

public class HopDongActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLuu,btnCancel;
    private EditText etMaHopDong,etCMND,etngayBatDauThue,etngayKy,etMoTa,tvTenKH,
    etTienCoc,etThoiHanThue,etMaPhongThue;
    private Controller db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hop_dong);
        btnCancel=findViewById(R.id.btnCancel);
        etMaHopDong=findViewById(R.id.etMaHopDong);
        etCMND=findViewById(R.id.etSoCMND);
        etngayBatDauThue=findViewById(R.id.etNgayBatDauThue);
        etngayKy=findViewById(R.id.etNgayKy);
        etMoTa=findViewById(R.id.etMoTa);
        etTienCoc=findViewById(R.id.etTienCoc);
        etThoiHanThue=findViewById(R.id.etThoiHanThue);
        etMaPhongThue=findViewById(R.id.etMaPhong);
        tvTenKH=findViewById(R.id.etTenKH);
        btnLuu=findViewById(R.id.btnLuu);
        db=new Controller();
        Intent intent=getIntent();
        String maphongthue=intent.getStringExtra("MaPhong");
        etMaPhongThue.setText(maphongthue);
        etCMND.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnLuu.setOnClickListener(this);
        etngayKy.setOnClickListener(this);
        etngayBatDauThue.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==etCMND){
            String cmnd=etCMND.getText().toString();
            String tenKH=db.searchTenNhanVienByCMND(cmnd);
            tvTenKH.setText(tenKH);
        }
        if (view==btnCancel){
            Intent intent=new Intent(HopDongActivity.this, DatPhongActivity.class);
            startActivity(intent);
            finish();
        }
        if(view==btnLuu){
            String maHD=etMaHopDong.getText().toString();
            String cmnd=etCMND.getText().toString();
            int idKH=db.searchIdNhanVienByCMND(cmnd);
            String ngaybatdauthue=etngayBatDauThue.getText().toString();
            String mota=etMoTa.getText().toString();
            float tiencoc=Float.parseFloat(etTienCoc.getText().toString());
            int thoihan=Integer.parseInt(etThoiHanThue.getText().toString());
            String ngayky=etngayKy.getText().toString();
            int maPhong = Integer.parseInt(etMaPhongThue.getText().toString());
            HopDong hopDong=new HopDong(maHD,idKH,ngaybatdauthue,mota,tiencoc,thoihan,ngayky,maPhong);
            db.addHopDong(hopDong);
            db.updateTinhTrangPhong(maPhong);
//            Toast.makeText(this,String.valueOf(idKH),Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(HopDongActivity.this, ThongBaoKetThucActivity.class);
            startActivity(intent);
            finish();
        }
        if(view==etngayBatDauThue){
            final Calendar c=Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog=new DatePickerDialog(HopDongActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String mm="",dd="";
                    if (m<10){
                        mm="0"+(m+1);
                    }
                    else mm=(m+1)+"";
                    if (d<10){
                        dd="0"+d;
                    }
                    else dd=d+"";
                    etngayBatDauThue.setText(dd+"/"+mm+"/"+y);
                }
            },year,month,day);
            dialog.show();
        }
        if(view==etngayKy){
            final Calendar c=Calendar.getInstance();
            int year= c.get(Calendar.YEAR);
            int month= c.get(Calendar.MONTH);
            int day= c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog=new DatePickerDialog(HopDongActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    String mm="",dd="";
                    if (m<10){
                        mm="0"+(m+1);
                    }
                    else mm=(m+1)+"";
                    if (d<10){
                        dd="0"+d;
                    }
                    else dd=d+"";
                    etngayKy.setText(dd+"/"+mm+"/"+y);
                }
            },year,month,day);
            dialog.show();
        }
    }
}

