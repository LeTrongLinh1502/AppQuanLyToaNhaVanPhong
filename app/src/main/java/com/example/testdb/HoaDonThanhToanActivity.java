package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.testdb.adapter.RecycleViewAdapterHoaDon;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.HoaDon;
import com.example.testdb.model.Phong;

import java.util.Collections;
import java.util.List;

public class HoaDonThanhToanActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Controller db;
    private RecycleViewAdapterHoaDon adapter;
    private EditText edSearch;
    private List<HoaDon> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_thanh_toan);
        recyclerView=findViewById(R.id.recycleView);
        Toolbar toolbar = findViewById(R.id.toolbar2); //Ignore red line errors
        setSupportActionBar(toolbar);
        edSearch=findViewById(R.id.edsearch);
        db=new Controller();
        adapter=new RecycleViewAdapterHoaDon(this);
        list=db.getAllHoaDon();
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
//        adapter.setItemListener(this);
        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.toString().isEmpty()){
                    list=db.getAllHoaDon();
                    adapter.setList(list);
                    adapter.notifyDataSetChanged();
                }else {
                    int idNhanVien=db.searchIdNhanVienByCMND(editable.toString());
                    list=db.searchHoaDonByIDKhachHang(idNhanVien);
                    adapter.setList(list);
                    adapter.notifyDataSetChanged();

                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        list=db.getAllHoaDon();
        adapter.setList(list);
        adapter.notifyDataSetChanged();
    }
    //    @Override
//    public void onItemClick(View view, int position) {
//
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_filter_hoadon,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =item.getItemId();
        if(id ==R.id.sort_price){
            Collections.sort(list);
            adapter.notifyDataSetChanged();

        }else if(id ==R.id.chuathanhtoan){
            list=db.searchHoaDonByTinhTrang();
            adapter.setList(list);
        }
        return super.onOptionsItemSelected(item);
    }
}