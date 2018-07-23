package com.example.aryasa.drawersayur.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aryasa.drawersayur.Drawer;
import com.example.aryasa.drawersayur.MapsDirection;
import com.example.aryasa.drawersayur.R;


public class Admindetailtransaksi extends AppCompatActivity {
 Button btn_lihat_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindetailtransaksi);

        btn_lihat_map = (Button) findViewById(R.id.buttonmap);
        btn_lihat_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admindetailtransaksi.this, MapsDirection.class);
                startActivity(intent);
            }
        });

    }
}
