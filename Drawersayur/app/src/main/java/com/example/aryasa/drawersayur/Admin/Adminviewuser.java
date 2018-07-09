package com.example.aryasa.drawersayur.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aryasa.drawersayur.R;


public class Adminviewuser extends AppCompatActivity {

    ImageView imguser;
    TextView txt_nama;
    TextView txt_email;
    TextView txt_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminviewuser);

        txt_nama = findViewById(R.id.txt_username);
        txt_email = findViewById(R.id.txt_notelp);
        txt_no = findViewById(R.id.txt_email);
        imguser = findViewById(R.id.userphoto);


        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            txt_nama.setText(mBundle.getString("nama"));
            imguser.setImageResource(mBundle.getInt("gambar"));
            txt_email.setText(mBundle.getString("email"));
            txt_no.setText(mBundle.getString("notelp"));
        }
    }
}
