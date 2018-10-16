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
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.aryasa.drawersayur.Admin.AdminHome;
import com.example.aryasa.drawersayur.Fragment.FragmentHelp;
import com.example.aryasa.drawersayur.Fragment.FragmentNotifikasi;
import com.example.aryasa.drawersayur.Fragment.HomeFragment;

public class Main extends AppCompatActivity  {


    Dialog myDialog;
    int idIntent;
    String username;
    SharedPreferences sharedpreferences;
    public static final String TAG_ID = "id";
    public static final String TAG_USERNAME = "username";
    private ActionBar toolbar;
    private BottomNavigationView bottomNavigation;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    public final static String TAG_NAME = "name";
    public final static String TAG_EMAIL = "email";
    public static final String TAG_NOMOR_TELEPON = "nomor_telepon";
    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String session_status = "session_status";
    public static final String session_status2 = "session_status2";

    Boolean session = false;
    Boolean sessionAdmin = false;
    int id;
    String name, nameIntent;
    String email, emailIntent;
    String nomor_telepon, nomor_teleponIntent;
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_drawer);
        toolbar = getSupportActionBar();
        myDialog = new Dialog(this);

        sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
        //sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        sessionAdmin = sharedpreferences.getBoolean(session_status2, false);
        id = sharedpreferences.getInt(TAG_ID, 0);
        name = sharedpreferences.getString(TAG_NAME, null);
        email = sharedpreferences.getString(TAG_EMAIL, null);
        nomor_telepon = sharedpreferences.getString(TAG_NOMOR_TELEPON, null);
//        idIntent = getIntent().getIntExtra(TAG_ID,0);
//        username = getIntent().getStringExtra(TAG_USERNAME);
//        nameIntent = getIntent().getStringExtra(TAG_NAME);
//        emailIntent = getIntent().getStringExtra(TAG_EMAIL);
//        nomor_teleponIntent = getIntent().getStringExtra(TAG_NOMOR_TELEPON);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);

//        if (session) {
//            idIntent = id;
//            nameIntent = email;
//            emailIntent = nomor_telepon;
//            nomor_teleponIntent = nomor_telepon;
//        }
        //Untuk mengganti icon login ke akun jika user sudah login
        if(sessionAdmin){
            Intent intent = new Intent(getApplicationContext(), AdminHome.class);
            startActivity(intent);
            finish();
        }

        if(!session){
            bottomNavigation.inflateMenu(R.menu.activity_drawer_drawer);
        }else{
            bottomNavigation.inflateMenu(R.menu.user_login_action_bar);
        }

        fragmentManager = getSupportFragmentManager();
        toolbar.setTitle("Beranda");
        //Untuk inisialisasi fragment pertama kali
        fragmentManager.beginTransaction().replace(R.id.frameLayoutDrawer, new HomeFragment()).commit();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(!session){
                    switch (id){
                        case R.id.nav_home:
                            toolbar.setTitle("Beranda");
                            fragment = new HomeFragment();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_history:
                            toolbar.setTitle("Transaksi");
                            fragment = new History();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_notifkasi:
                            toolbar.setTitle("Notifikasi");
                            fragment = new FragmentNotifikasi();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_help:
                            toolbar.setTitle("Bantuan");
                            fragment = new FragmentHelp();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_login:
                            intent = new Intent(Main.this, Login.class);
                            startActivity(intent);
                            break;
                    }
                }else{
                    switch (id){
                        case R.id.nav_home:
                            toolbar.setTitle("Beranda");
                            fragment = new HomeFragment();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_history:
                            toolbar.setTitle("Transaksi");
                            fragment = new History();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_notifkasi:
                            toolbar.setTitle("Notifikasi");
                            fragment = new FragmentNotifikasi();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_help:
                            toolbar.setTitle("Bantuan");
                            fragment = new FragmentHelp();
                            loadFragment(fragment);
                            break;
                        case R.id.nav_profile_admin:
                            Intent intent = new Intent(Main.this, Profile.class);
//                            intent.putExtra("id", idIntent);
//                            intent.putExtra(TAG_NAME, nameIntent);
//                            intent.putExtra(TAG_EMAIL, emailIntent);
//                            intent.putExtra(TAG_NOMOR_TELEPON, nomor_teleponIntent);
                            startActivity(intent);
                            break;
                    }
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
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//     //// Inflate the menu; this adds items to the action bar if it is present.
//     getMenuInflater().inflate(R.menu.drawer, menu);
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
//        if (id == R.id.search) {
//            return true;
//        }
//        if (id == R.id.cart) {
//            Intent cart = new Intent(Main.this, Chart.class);
//            startActivity(cart);
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


//    public void ShowPopup(View v) {
//        myDialog.setContentView(R.layout.popupbtnadd);
//        myDialog.show();
//    }

