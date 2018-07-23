package com.example.aryasa.drawersayur.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aryasa.drawersayur.Adpater.AdminCompletedAdapter;
import com.example.aryasa.drawersayur.Adpater.AdminInprogressAdapter;
import com.example.aryasa.drawersayur.Model.AdminCompleted;
import com.example.aryasa.drawersayur.Model.AdminInprogress;
import com.example.aryasa.drawersayur.R;

import java.util.ArrayList;

public class FragmentAdminHistoryInprogress extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_admin_history_inprogress, container, false);
        ArrayList<AdminInprogress> adminInprogress = new ArrayList<>();

        adminInprogress.add(new AdminInprogress("bayam","wortel","buncis",  R.drawable.sayur,"19-08-2018","08.00 WIB"));
        adminInprogress.add(new AdminInprogress("kemangi","selai","daun jeruk",  R.drawable.sayur,"19-08-2018","08.00 WIB"));
        adminInprogress.add(new AdminInprogress("sayur","mayur","enak",  R.drawable.sayur,"19-08-2018","08.00 WIB"));
        adminInprogress.add(new AdminInprogress("sayur","mayur","enak",  R.drawable.sayur,"19-08-2018","08.00 WIB"));

        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_admin_history_inporgress);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        AdminInprogressAdapter adminInprogressAdapter = new AdminInprogressAdapter(this.getContext(), adminInprogress);
        mRecyclerView.setAdapter(adminInprogressAdapter);

        return view;
    }
}