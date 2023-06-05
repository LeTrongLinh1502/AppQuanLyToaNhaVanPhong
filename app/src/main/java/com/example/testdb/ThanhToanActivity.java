package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.testdb.controller.Controller;
import com.example.testdb.model.HoaDon;

public class ThanhToanActivity extends AppCompatActivity {
    private ImageView img;
    private TextView tvMaHoaDon,tvTenKH,tvHanDong,tvNgayTao,tvTienThanhToan,tvLoaiHD,tvTinhTrang;
    private Spinner spPhuongThucThanhToan;
    private HoaDon hoaDon;
    private Button btnThanhToan, btnCancel;
    private Controller db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        img=findViewById(R.id.imgHoaDon);
        tvMaHoaDon=findViewById(R.id.tvMaHoaDon);
        tvTenKH=findViewById(R.id.tvTenKH);
        tvHanDong=findViewById(R.id.tvHanDong);
        tvNgayTao=findViewById(R.id.tvNgayTao);
        tvTienThanhToan=findViewById(R.id.tvTienThanhToan);
        tvLoaiHD=findViewById(R.id.tvLoaiHoaDon);
        tvTinhTrang=findViewById(R.id.tvTinhTrang);
        btnThanhToan=findViewById(R.id.btnThanhToan);
        btnCancel=findViewById(R.id.btnCancel);
        spPhuongThucThanhToan=findViewById(R.id.spPhuongThucThanhToan);
        spPhuongThucThanhToan.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,
                getResources().getStringArray(R.array.PhuongThucThanhToan)));
        Intent intent=getIntent();
        String ten=intent.getStringExtra("TenKhachHang");
        tvTenKH.setText("Tên khách hàng: "+ten);
        hoaDon= (HoaDon) intent.getSerializableExtra("HoaDon");
        tvMaHoaDon.setText("Code: "+hoaDon.getMaHoaDon());
        tvHanDong.setText("Hạn nộp: "+hoaDon.getHanDong());
        tvNgayTao.setText("Ngày tạo: "+hoaDon.getNgayXuat());
        tvTienThanhToan.setText("Tiền hóa đơn: "+String.valueOf(hoaDon.getTongTien())+" VNĐ");
        tvLoaiHD.setText("Hóa đơn: "+hoaDon.getLoaiHoaDon());
        tvTinhTrang.setText(hoaDon.getTinhTrang());
        if(hoaDon.getLoaiHoaDon().equals("Tiền điện")){
            img.setImageResource(R.drawable.hoadon_dien);
        }
        else if(hoaDon.getLoaiHoaDon().equals("Tiền nước")){
            img.setImageResource(R.drawable.hoadon_nuoc);
        }
        else  img.setImageResource(R.drawable.hoadon_dichvu);
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=new Controller();
                String phuongthuc=spPhuongThucThanhToan.getSelectedItem().toString();
                db.updateTinhTrangHoaDon(hoaDon.getMaHoaDon(),phuongthuc);
                Intent intent=new Intent(ThanhToanActivity.this, ThongBaoThanhToanOkActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThanhToanActivity.this, HoaDonThanhToanActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}