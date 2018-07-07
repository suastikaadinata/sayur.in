package com.example.aryasa.drawersayur.Fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aryasa.drawersayur.Adpater.SayurAdapter;
import com.example.aryasa.drawersayur.Adpater.SayurListAdapter;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.Model.SayurListModel;
import com.example.aryasa.drawersayur.R;

import java.util.ArrayList;


public class AdminListSayur extends Fragment {

    Button buttonedit;


    public AdminListSayur() {
        // Required empty public constructor
    }

    @Override



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_admin_list_sayur, container, false);
        ArrayList<SayurListModel> listSayur = new ArrayList<>();
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur));
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur1));
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur));
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur1));

        buttonedit = (Button) view.findViewById(R.id.btn_edit_sayur_admin_list);
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewadminlistsayur);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        SayurListAdapter sayurListAdapter = new SayurListAdapter(this.getContext(), listSayur);
        mRecyclerView.setAdapter(sayurListAdapter);
//        buttonedit.setOnClickListener(new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                // adminubahsayur
//            }
//        });
        return view;

    }
}
