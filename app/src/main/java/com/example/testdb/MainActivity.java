package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawerLayout;
    private Button btnQuanLy,btnDatPhong,btnHopDong,btnHoaDon;
    private TextView tvEmail;
    private ConstraintLayout layout;
    private NavigationView navigationView;
    FirebaseAuth auth ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar2); //Ignore red line errors
        setSupportActionBar(toolbar);
        layout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
        //set entry and exit duration
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();
//        tvEmail=findViewById(R.id.emailUser);
//        tvEmail.setText("OKOK");
        btnQuanLy=findViewById(R.id.btnQuanLy);
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.button_quanly_animation);
//        btnQuanLy.startAnimation(animation);
        btnDatPhong=findViewById(R.id.btnDatPhong);
        btnHopDong=findViewById(R.id.btnHopDong);
        btnHoaDon=findViewById(R.id.btnHoaDon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view=navigationView.getHeaderView(0);
        tvEmail=view.findViewById(R.id.emailUser);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String email = user.getEmail();
            tvEmail.setText(email);

        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_home);
        }
        btnQuanLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this ,QuanLyActivity.class));
            }
        });
        btnDatPhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , DatPhongActivity.class));
            }
        });
        btnHopDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this ,DanhSachHopDongActivity.class));
            }
        });
        btnHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this ,HoaDonThanhToanActivity.class));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
//                Intent intent =new Intent(MainActivity.this,HomeActivity.class);
//                startActivity(intent);
                break;
            case R.id.nav_quanly:
                startActivity(new Intent(MainActivity.this , QuanLyActivity.class));
                break;
            case R.id.nav_datphong:
                startActivity(new Intent(MainActivity.this , DatPhongActivity.class));
                break;
            case R.id.nav_hopdong:
                startActivity(new Intent(MainActivity.this , DanhSachHopDongActivity.class));
                break;
            case R.id.nav_hoadon:
                startActivity(new Intent(MainActivity.this , HoaDonThanhToanActivity.class));
                break;
            case R.id.nav_about:
                startActivity(new Intent(MainActivity.this , ThongTinAppActivity.class));
                break;
            case R.id.nav_logout:
                Intent intent =new Intent(MainActivity.this,LoginActivity.class);
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                startActivity(intent);
//                startActivity(new Intent(MainActivity.this , LoginActivity.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}