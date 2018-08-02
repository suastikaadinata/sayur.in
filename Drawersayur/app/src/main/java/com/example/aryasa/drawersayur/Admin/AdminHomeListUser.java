package com.example.aryasa.drawersayur.Admin;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aryasa.drawersayur.Chart;
import com.example.aryasa.drawersayur.Drawer;
import com.example.aryasa.drawersayur.Fragment.AdminListSayur;
import com.example.aryasa.drawersayur.Fragment.FragmentHelp;
import com.example.aryasa.drawersayur.Fragment.FragmentNotifikasi;
import com.example.aryasa.drawersayur.Fragment.HomeFragment;
import com.example.aryasa.drawersayur.History;
import com.example.aryasa.drawersayur.Login;
import com.example.aryasa.drawersayur.R;
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

public class AdminHomeListUser extends AppCompatActivity {
    Dialog myDialog;

    private Fragment fragment;
    private BottomNavigationView bottomNavigation;
    private ActionBar toolbar;
    private FragmentManager fragmentManager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        myDialog = new Dialog(this);
        toolbar = getSupportActionBar();
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_admin);
        bottomNavigation.inflateMenu(R.menu.bot_menu_admin);
        fragmentManager = getSupportFragmentManager();
        toolbar.setTitle("Daftar Sayur");

        //Untuk inisialisasi fragment pertama kali
        fragmentManager.beginTransaction().replace(R.id.container_admin, new Adminhomeuser()).commit();
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_home_admin:
                        toolbar.setTitle("Daftar Sayur");
                        fragment = new AdminListSayur();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_pengguna_admin:
                        toolbar.setTitle("Daftar User");
                        fragment = new Adminhomeuser();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_gudang_admin:
                        toolbar.setTitle("Gudang");
                        fragment = new AdminSayurGudang();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_transaksi_admin:
                        toolbar.setTitle("Transaksi");
                        fragment = new Adminhistory();
                        loadFragment(fragment);
                        break;
                    case R.id.nav_profile_admin:
                        intent = new Intent(AdminHomeListUser.this, Login.class);
                        //   finish();
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
        transaction.replace(R.id.container_admin, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //// Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.draweradmin, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.search_admin) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
