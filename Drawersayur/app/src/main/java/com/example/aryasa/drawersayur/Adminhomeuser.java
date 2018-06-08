package com.example.aryasa.drawersayur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.aryasa.drawersayur.Adpater.AdminuserAdapter;

import java.util.ArrayList;
import java.util.List;

public class Adminhomeuser extends AppCompatActivity {


    RecyclerView mRecyclerView;
    List<Userdata> mUserList;
    Userdata mUserData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhomeuser);

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

    }
}