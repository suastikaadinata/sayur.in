package com.example.aryasa.drawersayur;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        ArrayList<Sayur> listSayur = new ArrayList<Sayur>();
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.tulip));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.carnation));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.tulip));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.carnation));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.tulip));
        listSayur.add(new Sayur("Bayam", "500.000",R.drawable.carnation));


        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        SayurAdapter sayurAdapter = new SayurAdapter(this.getContext() ,listSayur);
        mRecyclerView.setAdapter(sayurAdapter);
        return view;

    }

}
