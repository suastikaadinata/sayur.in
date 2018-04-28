package com.sayurin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
public class Process extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.process);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarProcess);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Process");
    }
}
