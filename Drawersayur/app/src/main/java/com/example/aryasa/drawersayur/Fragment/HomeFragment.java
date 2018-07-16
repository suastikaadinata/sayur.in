package com.example.aryasa.drawersayur.Fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.aryasa.drawersayur.Adpater.SayurAdapter;
import com.example.aryasa.drawersayur.Chart;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Model.Sayur;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    List<Sayur> msayurlist;
    Sayur mSayurData;
    Context context;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        ArrayList<Sayur> listSayur = new ArrayList<Sayur>();
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.sayur));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.sayur1));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.sayur));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.sayur1));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.sayur));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.sayur1));


        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        SayurAdapter sayurAdapter = new SayurAdapter(this.getContext() ,listSayur);
        mRecyclerView.setAdapter(sayurAdapter);
        return view;

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.drawer, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search){
            return true;
        }
        if (id == R.id.cart) {
            Intent cart = new Intent(getActivity(), Chart.class);
            startActivity(cart);
        }
        return super.onOptionsItemSelected(item);
    }

}
