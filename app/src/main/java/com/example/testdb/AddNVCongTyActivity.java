package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.testdb.controller.Controller;
import com.example.testdb.model.CongTy;
import com.example.testdb.model.NhanVienCongTy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddNVCongTyActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edTenNV,edDiaChi,edCMT,edNgaySinh,edEmail;
    private Spinner spGioiTinh,spChucVu,spCongTy;
    private Button btnAdd,btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nv_congty);
        initView();
        edNgaySinh.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    private void initView() {
        edTenNV=findViewById(R.id.edTenNV);
        edDiaChi=findViewById(R.id.edDiaChi);
        edCMT=findViewById(R.id.edCMT);
        edNgaySinh=findViewById(R.id.edNgaySinh);
        edEmail=findViewById(R.id.edEmail);
        spGioiTinh=findViewById(R.id.spGioiTinh);
        spChucVu=findViewById(R.id.spChucVu);
        spCongTy=findViewById(R.id.spCongTy);
        btnAdd=findViewById(R.id.btnAdd);
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

    }

    @Override
    public void onClick(View view) {
        if(view==btnCancel){
            finish();
        }
        if (view==edNgaySinh){
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(AddNVCongTyActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int y, int m, int d) {
                    edNgaySinh.setText(y+"/"+(m+1)+"/"+d);
                }
            },year, month, day);
            datePickerDialog.show();
        }
        if (view==btnAdd){
            String diachi=edDiaChi.getText().toString();
            String hoten=edTenNV.getText().toString();
            String gioitinh=spGioiTinh.getSelectedItem().toString();
            String cmt=edCMT.getText().toString();
            String ngaysinh=edNgaySinh.getText().toString();
            String email=edEmail.getText().toString();
            String chucvu=spChucVu.getSelectedItem().toString();
            int solanravao=0,solanvao=0,solanra=0;
            Controller db=new Controller();
            int iDcongty=db.searchIdCongTyByTen(spCongTy.getSelectedItem().toString());
            NhanVienCongTy nv= new NhanVienCongTy(diachi,hoten,gioitinh,cmt,ngaysinh,email,chucvu,
                    solanravao,iDcongty,solanvao,solanra);
            db.addNVCongTy(nv);
            startActivity(new Intent(AddNVCongTyActivity.this ,QuanLyNhanVienCongTyActivity.class));
        }
    }
}