package com.example.aryasa.drawersayur.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import com.example.aryasa.drawersayur.Adpater.AdminuserAdapter;
import com.example.aryasa.drawersayur.Chart;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Model.Userdata;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

public class Adminhomeuser extends AppCompatActivity {


    Button btnlihatuser;
    RecyclerView mRecyclerView;
    List<Userdata> mUserList;
    Userdata mUserData;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhomeuser);



        btnlihatuser = (Button) findViewById(R.id.btn_lihat_sayur);
        mRecyclerView = findViewById(R.id.recyclerviewadminhomeuser);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(Adminhomeuser.this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        mUserList = new ArrayList<>();
        mUserData = new Userdata("Jhon Doe","jhon.Doe@gmail.com","081233816774",  R.drawable.ic_person_pin_green_150dp);
        mUserList.add(mUserData);
        mUserData = new Userdata("Jhon Thor","jhon.Thor@gmail.com","081233816778",  R.drawable.ic_person_pin_green_150dp);
        mUserList.add(mUserData);
        mUserData = new Userdata("Jhon Teo","jhon.Teo@gmail.com","081233816770",  R.drawable.ic_person_pin_green_150dp);
        mUserList.add(mUserData);
        mUserData = new Userdata("Jhon Div","jhon.Div@gmail.com","081233816771",  R.drawable.ic_person_pin_green_150dp);
        mUserList.add(mUserData);

        AdminuserAdapter adminuserAdapter = new AdminuserAdapter(Adminhomeuser.this, mUserList);
        mRecyclerView.setAdapter(adminuserAdapter);

//        btnlihatuser.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent = new Intent(Adminhomeuser.this, Adminviewuser.class);
//                finish();
//                startActivity(intent);
//
//            }
//        });

    }
}
