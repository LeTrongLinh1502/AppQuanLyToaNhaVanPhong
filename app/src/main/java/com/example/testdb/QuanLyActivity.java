package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class QuanLyActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private Button btnCongTy,btnNVCongTy,btnNVToaNha,btnDichVu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quan_ly);
        Toolbar toolbar = findViewById(R.id.toolbar2); //Ignore red line errors
        btnCongTy=findViewById(R.id.btnCongTy);
        btnNVCongTy=findViewById(R.id.btnNVCongTy);
        btnNVToaNha=findViewById(R.id.btnNVToaNha);
        btnDichVu=findViewById(R.id.btnDichVu);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_quanly);
        }
        btnCongTy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuanLyActivity.this ,QuanLyCongTyActivity.class));
            }
        });
        btnNVCongTy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuanLyActivity.this ,QuanLyNhanVienCongTyActivity.class));
            }
        });
        btnNVToaNha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuanLyActivity.this ,QuanLyNhanVienToaNhaActivity.class));
            }
        });
        btnDichVu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuanLyActivity.this ,QuanLyDichVuActivity.class));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent =new Intent(QuanLyActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_quanly:
                startActivity(new Intent(QuanLyActivity.this , QuanLyActivity.class));
                break;
            case R.id.nav_datphong:
                startActivity(new Intent(QuanLyActivity.this , DatPhongActivity.class));
                break;
            case R.id.nav_hopdong:
                startActivity(new Intent(QuanLyActivity.this , DanhSachHopDongActivity.class));
                break;
            case R.id.nav_hoadon:
                startActivity(new Intent(QuanLyActivity.this , HoaDonThanhToanActivity.class));
                break;
            case R.id.nav_about:
                startActivity(new Intent(QuanLyActivity.this , ThongTinAppActivity.class));
                break;
            case R.id.nav_logout:
                startActivity(new Intent(QuanLyActivity.this , LoginActivity.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}