package com.example.customkuy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StatusPesananActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_pesanan);

        getSupportActionBar().hide();
    }
}
