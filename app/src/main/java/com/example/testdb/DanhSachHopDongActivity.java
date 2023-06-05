package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.EditText;

import com.example.testdb.adapter.RecycleViewAdapterHopDong;
import com.example.testdb.controller.Controller;
import com.example.testdb.model.HopDong;

import java.util.List;

public class DanhSachHopDongActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Controller db;
    private RecycleViewAdapterHopDong adapter;
    private EditText edSearch;
    private List<HopDong> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_hop_dong);
        recyclerView=findViewById(R.id.recycleView);
        edSearch=findViewById(R.id.edsearch);
        db=new Controller();
        adapter=new RecycleViewAdapterHopDong();
        list=db.getAllHopDong();
        adapter.setList(list);
        LinearLayoutManager manager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
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
                    list=db.getAllHopDong();
                    adapter.setList(list);
                    adapter.notifyDataSetChanged();
                }else {
                    int idNhanVien=db.searchIdNhanVienByCMND(editable.toString());
                    list=db.searchHopDongByIDKhachHang(idNhanVien);
                    adapter.setList(list);
                    adapter.notifyDataSetChanged();

                }
            }
        });
    }

}