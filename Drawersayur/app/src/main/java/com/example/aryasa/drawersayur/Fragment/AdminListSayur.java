package com.example.aryasa.drawersayur.Fragment;

import android.support.v4.app.Fragment;
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
import com.example.aryasa.drawersayur.Adpater.SayurListAdapter;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.Model.SayurListModel;
import com.example.aryasa.drawersayur.R;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;


public class AdminListSayur extends Fragment {

    List<Sayur> msayurlist;
    Sayur mSayurData;
    Context context;

    public AdminListSayur() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_admin_list_sayur, container, false);
        ArrayList<SayurListModel> listSayur = new ArrayList<>();
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur));
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur1));
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur));
        listSayur.add(new SayurListModel("Bayam", "500.000", R.drawable.sayur1));

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewadminlistsayur);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(this.getContext(), 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        SayurListAdapter sayurListAdapter = new SayurListAdapter(this.getContext(), listSayur);
        mRecyclerView.setAdapter(sayurListAdapter);

        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.admin_action_bar_sayur, menu);
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
