package com.example.aryasa.drawersayur.Admin;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.aryasa.drawersayur.Adpater.SayurGudangAdapter;
import com.example.aryasa.drawersayur.Model.SayurGudangModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminSayurGudang extends Fragment {
    private String API_URL = Server.URL + "sayur";;
    ArrayList<SayurGudangModel> sayurGudangList = new ArrayList<SayurGudangModel>();
    SwipeRefreshLayout swipeRefreshLayout;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.activity_sayur_gudang, container, false);
        swipeRefreshLayout = view.findViewById(R.id.swipecontainer);
        final SayurGudangAdapter sayurGudangAdapter = new SayurGudangAdapter(view.getContext(), sayurGudangList);
        getSayurApi(API_URL, view, sayurGudangAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        sayurGudangAdapter.clear();
                        getSayurApi(API_URL, view, sayurGudangAdapter);
                    }
                }, 1000);
            }
        });
        return view;
    }

    public void getSayurApi(String url, final View view, final SayurGudangAdapter sayur){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               try{
                   for (int i = 0; i < response.length(); i++){
                       JSONObject jsonObject = response.getJSONObject(i);
                       sayurGudangList.add(new SayurGudangModel("http://10.0.3.2/img/"+jsonObject.getString("foto") ,jsonObject.getString("nama"), jsonObject.getInt("harga")));
                       RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewsayurgudang);
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
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/json");
                headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjVhNjRkZTRlZDM5MDllMTkwYzc4NjA2MDg5M2M2ZGVkMDljNTAyZDJjZmUwYTE4NzU1NTI1ZGQxZjI0MjAyNzNlM2FjNzY5MzQ4NWIzNmFhIn0.eyJhdWQiOiIzIiwianRpIjoiNWE2NGRlNGVkMzkwOWUxOTBjNzg2MDYwODkzYzZkZWQwOWM1MDJkMmNmZTBhMTg3NTU1MjVkZDFmMjQyMDI3M2UzYWM3NjkzNDg1YjM2YWEiLCJpYXQiOjE1MzEyODk3NTksIm5iZiI6MTUzMTI4OTc1OSwiZXhwIjoxNTYyODI1NzU5LCJzdWIiOiIxIiwic2NvcGVzIjpbXX0.frCouwNpBltMnVw8VaDPcrlKBKEswtuWDKFqQXWIpqX7-Cj9W5JmUolqYSCoN3zLl9keRusLVozL8aKRhCnG1c-6OICtZNkMOYLSQ8yLyyUgaYe-GInXgnYu232RqExuuYzpEBu_5D44UUkHagnJqGl4pH8PDCxrDSebaWnkUR6UfNiDdS2lol3Nysl7J_9t4d96_yAVQjkeljQXn1FkPsmRHukI4akF5SGdUaKeo15Ez9GFsEJUFeXRBEqeumwjNLAC2nobSAgE7_ib7zzrvMP5K0kihif4_o4oGbAQmQI_V41rZUB67W1ss8U6YsxZL38a_9WDz8FpSRMdIConBsTtn07rlgZbA9-e53HwLhAf5sXZzd7mTzCYsXE9LpC11r2dti66oMZaOFYnlsfVIMlhm_oNBARbgq1_6Bb8CTY6xZGwe1CeuwfUyMI-nOxtZsjRHztaJqV4WflOmYmYTvDQzEi4jOmRnmbVl1XpYSFXDBXKH_b5PWvY39GVqNeBtvu7AAJ5Qw3Lu6gxCL1Fek4mycZRNJ247N2BOiSgQnEp1KTwkg71EzTtL7rMdm3AqzIzMjXO3pH6ztQx6athKc47fCBxXfPOFVVOaKItjJ2UV9hDaYJsW9ejkhM69TfH9i3gfJtSuAeaBaci05HoSj6AYSVamh0eoB_SgrLJdPg");
                return headers;
            }
        };
        Singleton.getInstance(this.getContext()).addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.admin_action_bar_gudang, menu);
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
