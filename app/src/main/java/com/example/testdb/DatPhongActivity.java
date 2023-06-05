package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdb.adapter.RecycleViewAdapterDichVu;
import com.example.testdb.adapter.RecycleViewAdapterPhong;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;
import com.example.testdb.model.DichVu;
import com.example.testdb.model.Phong;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatPhongActivity extends AppCompatActivity implements RecycleViewAdapterPhong.ItemListener{
    private RecyclerView recycleView;
    private Controller db;
    private RecycleViewAdapterPhong adapter;
    private List<Phong> list;
    private TextView tvTong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_phong);
        Toolbar toolbar = findViewById(R.id.toolbar2); //Ignore red line errors
        setSupportActionBar(toolbar);
        recycleView=findViewById(R.id.recycleView);
        tvTong=findViewById(R.id.tvTong);
        adapter=new RecycleViewAdapterPhong(this);
        db=new Controller();
        list=db.getAllPhong();
        tvTong.setText("Số phòng chưa thuê: "+db.searchPhongChuaThue());
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
        adapter.setItemListener(this);
    }
    @Override
    public void onItemClick(View view, int position) {
        Phong phong= adapter.getItem(position);
        Intent intent=new Intent(DatPhongActivity.this, PhongChiTietActivity.class);
        intent.putExtra("Phong",phong);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_filter,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id ==R.id.sort_price){
            Collections.sort(list);
            adapter.notifyDataSetChanged();

        }else if(id ==R.id.phongchuathue){
                list=db.searchPhongByTinhTrang();
//            list =db.searchPhongByTinhTrang();
//            Toast.makeText(this,list.size()+"",Toast.LENGTH_SHORT).show();
//            adapter.notifyDataSetChanged();
            adapter.setList(list);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true ;
    }
}