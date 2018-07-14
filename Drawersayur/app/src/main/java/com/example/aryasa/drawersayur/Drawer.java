package com.example.aryasa.drawersayur;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.aryasa.drawersayur.Fragment.FragmentHelp;
import com.example.aryasa.drawersayur.Fragment.FragmentNotifikasi;
import com.example.aryasa.drawersayur.Fragment.HomeFragment;

public class Drawer extends AppCompatActivity  {
    Dialog myDialog;
    String id, username;
    SharedPreferences sharedpreferences;
    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";

    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_drawer);

        myDialog = new Dialog(this);

        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);

        id = getIntent().getStringExtra(TAG_ID);
        username = getIntent().getStringExtra(TAG_USERNAME);

        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigation.inflateMenu(R.menu.activity_drawer_drawer);
        fragmentManager = getSupportFragmentManager();

        //Untuk inisialisasi fragment pertama kali
        fragmentManager.beginTransaction().replace(R.id.frameLayoutDrawer, new HomeFragment()).commit();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_home:
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_history:
                        fragment = new History();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_help:
                        fragment = new FragmentHelp();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_notifkasi:
                        fragment = new FragmentNotifikasi();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_login:
                     intent = new Intent(Drawer.this, Login.class);
                       // finish();
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayoutDrawer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     //// Inflate the menu; this adds items to the action bar if it is present.
     getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }
        if (id == R.id.cart) {
            Intent cart = new Intent(Drawer.this, Chart.class);
            startActivity(cart);
        }

        return super.onOptionsItemSelected(item);
    }


    public void ShowPopup(View v) {
        myDialog.setContentView(R.layout.popupbtnadd);
        myDialog.show();

    }
}

