package com.example.customkuy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class KonfirmasiBarangAnda extends AppCompatActivity implements View.OnClickListener {

    RadioButton terima1, terima2, terima3;

    Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_barang_anda);
        getSupportActionBar().hide();

        btn_order = findViewById(R.id.btn_order);
        terima1 = findViewById(R.id.terima1);
        terima2 = findViewById(R.id.terima2);
        terima3 = findViewById(R.id.terima3);

        terima1.setOnClickListener(this);


        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KonfirmasiBarangAnda.this, BayarActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.terima1:
                if (terima1.isSelected()) {
                    terima1.setSelected(false);
                    terima1.setChecked(false);
                } else {
                    terima1.setSelected(true);
                    terima1.setChecked(true);
                }

                break;
        }
    }
}