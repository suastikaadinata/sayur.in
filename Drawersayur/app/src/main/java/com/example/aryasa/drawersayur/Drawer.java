package com.example.aryasa.drawersayur;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aryasa.drawersayur.Fragment.FragmentChat;
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
                        break;
                    case R.id.nav_history:
                        intent = new Intent(Drawer.this, History.class);
                        finish();
                        startActivity(intent);
                        break;
                    case R.id.nav_login:
                      intent = new Intent(Drawer.this, Login.class);
                      finish();
                      startActivity(intent);
                        break;
                //    case R.id.nav_message:
                //        fragment = new FragmentChat();
                 //       break;
                }
//                final FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.replace(R.id.main_container, fragment).commit();
                return true;
            }
        });
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

