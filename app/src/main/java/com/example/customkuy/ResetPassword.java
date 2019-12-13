package com.example.customkuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    Button btn_kirim_email;
    EditText tulis_email;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        getSupportActionBar().hide();

        btn_kirim_email = findViewById(R.id.btn_kirim_email);
        tulis_email = findViewById(R.id.tulis_email);

        mAuth = FirebaseAuth.getInstance();

        btn_kirim_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usersEmail = tulis_email.getText().toString();

                if (TextUtils.isEmpty(usersEmail))
                {
                    Toast.makeText(ResetPassword.this,"masukan alamat email anda yang digunakan saat registrasi",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    mAuth.sendPasswordResetEmail(usersEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(ResetPassword.this,"Cek Email Anda",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ResetPassword.this,LoginActivity.class));
                            }

                            else
                            {
                                String message = task.getException().getMessage();
                                Toast.makeText(ResetPassword.this,"Email Error"+ message,Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });








    }
}
