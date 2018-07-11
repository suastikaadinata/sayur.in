package com.example.aryasa.drawersayur;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    TextView txt_email, txt_name, txt_nomor_telepon;
    Button btn_logout;
    String name, email, tlp;
    SharedPreferences sharedpreferences;

    public static final String TAG_NAME = "name";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_NOMOR_TELEPON = "nomor_telepon";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.edit_profil);

            txt_name = (TextView) findViewById(R.id.editTextnama);
            txt_email = (TextView) findViewById(R.id.editTextemail);
            txt_nomor_telepon = (TextView) findViewById(R.id.editTextNomorTelepon);
            btn_logout =(Button) findViewById(R.id.button_logout);
            sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);


            name = getIntent().getStringExtra(TAG_NAME);
            email = getIntent().getStringExtra(TAG_EMAIL);
            tlp = getIntent().getStringExtra(TAG_NOMOR_TELEPON);

            txt_name.setText(name);
            txt_email.setText(email);
            txt_nomor_telepon.setText(tlp);

            btn_logout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // update login session ke FALSE dan mengosongkan nilai id dan username
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(Login.session_status, false);
                    editor.putString(TAG_NAME, null);
                    editor.putString(TAG_EMAIL, null);
                    editor.putString(TAG_NOMOR_TELEPON, null);
                    editor.commit();

                    Intent intent = new Intent(Profile.this, Drawer.class);
                    finish();
                    startActivity(intent);
                }
            });
        }


    }
