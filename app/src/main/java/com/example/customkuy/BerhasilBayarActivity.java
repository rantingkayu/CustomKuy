package com.example.customkuy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.customkuy.Fragment.MenuActivity;

public class BerhasilBayarActivity extends AppCompatActivity {


    Button btn_ok;

    ProgressDialog pD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berhasil_bayar);
        getSupportActionBar().hide();

        btn_ok = findViewById(R.id.btn_ok);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD = new ProgressDialog(BerhasilBayarActivity.this);
                pD.setMessage("Tunggu Sebentar...");
                pD.show();

                startActivity(new Intent(BerhasilBayarActivity.this, MenuActivity.class));
            }
        });
    }
}
