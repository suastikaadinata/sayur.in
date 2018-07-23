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

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.aryasa.drawersayur.Adpater.SayurAdapter;
import com.example.aryasa.drawersayur.Adpater.SayurListAdapter;
import com.example.aryasa.drawersayur.Chart;
import com.example.aryasa.drawersayur.Model.SayurListModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private String API_URL = Server.URL + "sayur/dijual";
    ArrayList<Sayur> listSayur = new ArrayList<Sayur>();

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.fragment_home2, container, false);
        final SayurAdapter sayurAdapter = new SayurAdapter(view.getContext(), listSayur);
        getSayurApi(API_URL, view, sayurAdapter);
        return view;
    }

    public void getSayurApi(String url, final View view, final SayurAdapter sayur){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                    for (int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        listSayur.add(new Sayur("http://192.168.42.41/img/"+jsonObject.getString("foto") ,jsonObject.getString("nama"), jsonObject.getInt("harga")));
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(sayur);
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Singleton.getInstance(this.getContext()).addToRequestQueue(jsonArrayRequest);
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
