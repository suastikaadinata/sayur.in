package com.example.aryasa.drawersayur.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.aryasa.drawersayur.Adpater.PageAdapterAdmin;
import com.example.aryasa.drawersayur.Drawer;
import com.example.aryasa.drawersayur.R;


public class Adminhistory extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhistory);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_history_admin);
        tabLayout.addTab(tabLayout.newTab().setText("IN PROGRESS"));
        tabLayout.addTab(tabLayout.newTab().setText("Completed"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pageradmin);
        final PageAdapterAdmin adapter = new PageAdapterAdmin
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        tabLayout. addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        intent = new Intent(Adminhistory.this, Drawer.class);
        finish();
        startActivity(intent);
    }
}

