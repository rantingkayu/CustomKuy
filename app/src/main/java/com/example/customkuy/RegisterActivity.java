package com.example.customkuy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText jns_kelamin, nama_lengkap, email,alamat, password,no_telp;
    Button btn_register;
    TextView txt_to_login;

    FirebaseAuth auth;
    DatabaseReference reference;
    ProgressDialog pD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        jns_kelamin = findViewById(R.id.jns_kelamin);
        nama_lengkap = findViewById(R.id.nama_lengkap);
        no_telp = findViewById(R.id.no_telp);
        email = findViewById(R.id.email);
        alamat = findViewById(R.id.alamat);
        password = findViewById(R.id.password);
        btn_register = findViewById(R.id.btn_regis);
        txt_to_login = findViewById(R.id.to_login);

        auth = FirebaseAuth.getInstance();

        txt_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD = new ProgressDialog(RegisterActivity.this);
                pD.setMessage("Tunggu Sebentar...");
                pD.show();

                String str_jns_kelamin = jns_kelamin.getText().toString();
                String str_nama_lengkap = nama_lengkap.getText().toString();
                String str_email = email.getText().toString();
                String str_alamat = alamat.getText().toString();
                String str_no_telp = no_telp.getText().toString();
                String str_password = password.getText().toString();

                if (TextUtils.isEmpty(str_jns_kelamin) || TextUtils.isEmpty(str_nama_lengkap) ||TextUtils.isEmpty(str_alamat) || TextUtils.isEmpty(str_no_telp) || TextUtils.isEmpty(str_email) || TextUtils.isEmpty(str_password)){
                    Toast.makeText(RegisterActivity.this, "Semua data harus di isi", Toast.LENGTH_LONG).show();
                }
                else if (str_password.length() < 6){
                    Toast.makeText(RegisterActivity.this, "Password harus memiliki 6 karakter", Toast.LENGTH_SHORT).show();
                }
                else {
                    register(str_jns_kelamin, str_nama_lengkap,str_alamat, str_no_telp,str_email, str_password);
                }
            }
        });
    }

    private void register(final String jns_kelamin,final String alamat ,final String nama_lengkap ,final  String no_telp, String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userId = firebaseUser.getUid();

                            reference = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

                            HashMap<String, Object> hashMap = new HashMap<>();
                            hashMap.put("id", userId);
                            hashMap.put("nama_lengkap", nama_lengkap.toLowerCase());
                            hashMap.put("jns_kelamin", jns_kelamin);
                            hashMap.put("alamat",alamat);
                            hashMap.put("no_telp",no_telp);
                            hashMap.put("biodata", "");
                            hashMap.put("imageurl", "https://firebasestorage.googleapis.com/v0/b/customkuy-13041998.appspot.com/o/placeholder_user.png?alt=media&token=dce73a84-a3d8-4373-a9eb-554347fc0da2");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        pD.dismiss();
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        kosongkanText();


                                    }
                                }
                            });
                        }
                        else {
                            pD.dismiss();
                            Toast.makeText(RegisterActivity.this, "Anda tidak bisa mendaftar menggunakan E-Mail atau Password Tersebut", Toast.LENGTH_SHORT).show();
                        }


                    }
                });


    }

    private void kosongkanText(){
        nama_lengkap.setText(null);
        jns_kelamin.setText(null);
        alamat.setText(null);
        email.setText(null);
        password.setText(null);
        no_telp.setText(null);
    }
}
