package com.example.customkuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RiwayatTransaksiActivity extends AppCompatActivity {

    private TextView to_meja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_transaksi);
        getSupportActionBar().hide();

        to_meja = findViewById(R.id.to_meja);

        to_meja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RiwayatTransaksiActivity.this,MejaRiwayatTransaksiActivity.class));
            }
        });

    }
}
