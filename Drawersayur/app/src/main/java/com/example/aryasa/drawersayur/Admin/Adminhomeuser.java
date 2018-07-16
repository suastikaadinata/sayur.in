package com.example.aryasa.drawersayur.Admin;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.aryasa.drawersayur.Adpater.AdminuserAdapter;
import com.example.aryasa.drawersayur.Adpater.SayurListAdapter;
import com.example.aryasa.drawersayur.Chart;
import com.example.aryasa.drawersayur.Model.SayurListModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Model.Userdata;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

public class Adminhomeuser extends Fragment {


//    Button btnlihatuser;
//    RecyclerView mRecyclerView;
//    List<Userdata> mUserList;
//    Userdata mUserData;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.adminhomeuser, container, false);
        ArrayList<Userdata> userdata = new ArrayList<>();

        userdata.add(new Userdata("Jhon Doe","jhon.Doe@gmail.com","081233816774",  R.drawable.ic_person_pin_green_150dp));
        userdata.add(new Userdata("Jhon Thor","jhon.Thor@gmail.com","081233816778",  R.drawable.ic_person_pin_green_150dp));
        userdata.add(new Userdata("Jhon Teo","jhon.Teo@gmail.com","081233816770",  R.drawable.ic_person_pin_green_150dp));
        userdata.add(new Userdata("Jhon Div","jhon.Div@gmail.com","081233816771",  R.drawable.ic_person_pin_green_150dp));

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewadminhomeuser);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        AdminuserAdapter Adminuseradapter = new AdminuserAdapter(this.getContext(), userdata);
        mRecyclerView.setAdapter(Adminuseradapter);

        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.admin_action_bar_user, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
