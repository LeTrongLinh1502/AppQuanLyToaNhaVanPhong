package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private Button btnRegister,btnCancel;
    private EditText tvEmail,tvPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister=findViewById(R.id.btnSignUp);
        btnCancel=findViewById(R.id.btnCancel);
        tvEmail=findViewById(R.id.edtEmail);
        tvPass=findViewById(R.id.edtPassword);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRegister();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    private void onClickRegister() {
        if(tvEmail.getText().toString().equals("") || tvPass.getText().toString().equals("")){
            Toast.makeText(RegisterActivity.this, "Thông tin rỗng", Toast.LENGTH_SHORT).show();
        }
        else {
            LoadingDialog loadingDialog =new LoadingDialog(RegisterActivity.this);
            loadingDialog.ShowDialog("Đăng ký...");
            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            String email = tvEmail.getText().toString();
            String pass = tvPass.getText().toString();
            mAuth.createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                finishAffinity();
                                Toast.makeText(RegisterActivity.this, "Đăng ký thành công"
                                        ,Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}