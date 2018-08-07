package com.example.aryasa.drawersayur.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aryasa.drawersayur.Adpater.UserCompletedAdapter;
import com.example.aryasa.drawersayur.Adpater.UserInprogressAdapter;
import com.example.aryasa.drawersayur.Model.UserCompleted;
import com.example.aryasa.drawersayur.Model.Userdata;
import com.example.aryasa.drawersayur.R;

import java.util.ArrayList;

public class TabFragmentCompleted extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_fragment_completed, container, false);
        ArrayList<UserCompleted> usercompleted = new ArrayList<>();

        usercompleted.add(new UserCompleted("bayam","wortel","buncis",  R.drawable.sayur,"19-08-2018","08.00 WIB"));
        usercompleted.add(new UserCompleted("bayam","wortel","buncis",  R.drawable.sayur,"19-08-2018","08.00 WIB"));
        usercompleted.add(new UserCompleted("bayam","wortel","buncis",  R.drawable.sayur,"19-08-2018","08.00 WIB"));
        usercompleted.add(new UserCompleted("bayam","wortel","buncis",  R.drawable.sayur,"19-08-2018","08.00 WIB"));

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_fragment_completed);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        UserCompletedAdapter userCompletedAdapter = new UserCompletedAdapter(this.getContext(), usercompleted);
        mRecyclerView.setAdapter(userCompletedAdapter);
        return view;
    }
}
