package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private Button btnQuanLy,btnDatPhong,btnHopDong,btnHoaDon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnQuanLy=findViewById(R.id.btnQuanLy);
        btnDatPhong=findViewById(R.id.btnDatPhong);
        btnHopDong=findViewById(R.id.btnHopDong);
        btnHoaDon=findViewById(R.id.btnHoaDon);
        btnQuanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this ,QuanLyActivity.class));
            }
        });
        btnDatPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this , DatPhongActivity.class));
            }
        });
        btnHopDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this ,DanhSachHopDongActivity.class));
            }
        });
        btnHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this ,HoaDonThanhToanActivity.class));
            }
        });


    }
}