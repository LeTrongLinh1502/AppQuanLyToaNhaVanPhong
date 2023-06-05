package com.example.testdb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassActivity extends AppCompatActivity {
    private EditText edResetPass;
    private Button btnResetPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pass);
        edResetPass=findViewById(R.id.edtEmaiReset);
        btnResetPass=findViewById(R.id.btnResetPassword);
        btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth auth = FirebaseAuth.getInstance();
                String emailAddress = edResetPass.getText().toString();

                auth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(ForgetPassActivity.this,"Đã gửi email....",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(ForgetPassActivity.this , LoginActivity.class));
                                }
                                else Toast.makeText(ForgetPassActivity.this,"Email này chưa được đăng ký",Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }
}