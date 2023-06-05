package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.testdb.model.Phong;

public class PhongChiTietActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tvMaPhong,tvGiaPhong,tvDienTich,tvMoTa,tvLoaiPhong,tvTinhTrang;
    private Button btnDatPhong,btnCancel;
    private Phong phong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phong_chi_tiet);
        initView();

        Intent intent =getIntent();
        phong= (Phong) intent.getSerializableExtra("Phong");
        Glide.with(getApplicationContext()).load(phong.getUrl_img()).into(img);
        tvMaPhong.setText("Mã phòng: "+phong.getMaPhong());
        tvGiaPhong.setText("Giá phòng: "+String.valueOf(phong.getGiaPhong())+ " triệu đồng/tháng");
        tvDienTich.setText("Diện tích phòng: "+String.valueOf(phong.getDientich())+" m2");
        tvMoTa.setText("Mô tả: "+phong.getMota());
        tvLoaiPhong.setText("Loại phòng: "+phong.getLoaiPhong());
        tvTinhTrang.setText("Tình trạng: "+phong.getTinhTrangPhong());
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PhongChiTietActivity.this, DatPhongActivity.class);
                startActivity(intent);
                finish();
            }
        });
        if(phong.getTinhTrangPhong().equals("Đã thuê")) btnDatPhong.setVisibility(View.INVISIBLE);
        else  btnDatPhong.setVisibility(View.VISIBLE);
        btnDatPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PhongChiTietActivity.this, HopDongActivity.class);
                intent.putExtra("MaPhong",phong.getMaPhong());
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        img=findViewById(R.id.imgPhong);
        tvMaPhong=findViewById(R.id.tvMaPhong);
        tvGiaPhong=findViewById(R.id.tvGiaPhong);
        tvDienTich=findViewById(R.id.tvDienTich);
        tvMoTa=findViewById(R.id.tvMoTa);
        tvLoaiPhong=findViewById(R.id.tvLoaiPhong);
        tvTinhTrang=findViewById(R.id.tvTinhTrang);
        btnDatPhong=findViewById(R.id.btnDat);
        btnCancel=findViewById(R.id.btnCancel);
    }
}