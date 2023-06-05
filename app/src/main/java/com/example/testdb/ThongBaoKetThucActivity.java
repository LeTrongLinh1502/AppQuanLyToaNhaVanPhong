package com.example.testdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class ThongBaoKetThucActivity extends AppCompatActivity {
    private AppCompatButton btnHoanTat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao_ket_thuc);
        btnHoanTat=findViewById(R.id.btnFinish);
        btnHoanTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ThongBaoKetThucActivity.this, DatPhongActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}