package com.example.aryasa.drawersayur.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aryasa.drawersayur.R;


public class Adminubahsayur extends AppCompatActivity {

 ImageView gambar_sayur;
  TextView txt_nama;
  TextView txt_harga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminubahsayur);

        gambar_sayur = findViewById(R.id.gambar_sayur);
        txt_nama = findViewById(R.id.txt_namasayur);
        txt_harga = findViewById(R.id.txt_hargasayur);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            txt_nama.setText(mBundle.getString("nama"));
            gambar_sayur.setImageResource(mBundle.getInt("gambar"));
            txt_harga.setText(mBundle.getString("harga"));
        }

    }
}
