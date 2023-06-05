package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testdb.controller.Controller;
import com.example.testdb.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.SQLException;

public class LoginActivity extends AppCompatActivity {
    Button btnSignUp ,btnSignIn ;
    TextInputEditText edtUsername ,edtpassword;
    TextView tvForgetpass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnSignUp =findViewById(R.id.btnSignUp);
        edtUsername =findViewById(R.id.edtUsername);
        edtpassword =findViewById(R.id.edtPassword);
        btnSignIn =findViewById(R.id.btnSignIn);
        tvForgetpass=findViewById(R.id.tvforgotPassword);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickLogin();
//                if(edtUsername.getText().toString().equals("") || edtpassword.getText().toString().equals("")){
//                    Toast.makeText(LoginActivity.this, "Thông tin rỗng", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    LoadingDialog loadingDialog =new LoadingDialog(LoginActivity.this);
//                    loadingDialog.ShowDialog("Đăng nhập...");
//                    String taikhoan =edtUsername.getText().toString();
//                    String matkhau =edtpassword.getText().toString();
//                    try {
//                        Controller controller= new Controller();
//                        User user = controller.CheckLogin(new User(taikhoan,matkhau));
//                        if(user!=null) {
//                            loadingDialog.HideDialog();
//                            Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(LoginActivity.this ,MainActivity.class));
//                        }
//                        else
//                            Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
//                    } catch (SQLException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this ,RegisterActivity.class));
                finish();
            }
        });
        tvForgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, ForgetPassActivity.class));
                finish();
            }
        });
    }

    private void onClickLogin() {
        if(edtUsername.getText().toString().equals("") || edtpassword.getText().toString().equals("")){
                    Toast.makeText(LoginActivity.this, "Thông tin rỗng", Toast.LENGTH_SHORT).show();
                }
        else {
            LoadingDialog loadingDialog =new LoadingDialog(LoginActivity.this);
            loadingDialog.ShowDialog("Đăng nhập...");
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            String email = edtUsername.getText().toString();
            String pass = edtpassword.getText().toString();
            mAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            } else {
                                Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khấu", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }
    }

    @Override
    protected void onStart() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser !=null){
            startActivity(new Intent(LoginActivity.this ,MainActivity.class));
        }
        super.onStart();
    }
}