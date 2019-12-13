package com.example.customkuy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BayarActivity extends AppCompatActivity {

    Button btn_konfir;

    ProgressDialog pD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);
        getSupportActionBar().hide();

        btn_konfir = findViewById(R.id.btn_konfir);

        btn_konfir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pD = new ProgressDialog(BayarActivity.this);
                pD.setMessage("Sedang memproses...");
                pD.show();
                startActivity(new Intent(BayarActivity.this, KonfirmasiPembayaranActivity.class));
            }
        });
    }

}
