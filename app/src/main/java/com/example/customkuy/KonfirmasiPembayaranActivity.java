package com.example.customkuy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class KonfirmasiPembayaranActivity extends AppCompatActivity {
    private Uri filePath;


    private ImageView imageView;
    Button btn_konfirmasi,btn_ambil;
    ProgressDialog pD;


    private final int PICK_IMAGE_REQUEST = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_pembayaran);

        getSupportActionBar().hide();

        btn_ambil = findViewById(R.id.btn_ambil);
        imageView = findViewById(R.id.imageView);
        btn_konfirmasi = findViewById(R.id.btn_konfirmasi);



        btn_konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD = new ProgressDialog(KonfirmasiPembayaranActivity.this);
                pD.setMessage("Tunggu Sebentar...");
                pD.show();

                startActivity(new Intent(KonfirmasiPembayaranActivity.this, BerhasilBayarActivity.class));
            }
        });



        btn_ambil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();

            try {
                //getting image from gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
