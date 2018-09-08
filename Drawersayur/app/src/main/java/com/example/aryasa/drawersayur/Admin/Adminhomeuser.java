package com.example.aryasa.drawersayur.Admin;

import android.content.Context;
import android.content.SharedPreferences;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.aryasa.drawersayur.Adpater.AdminuserAdapter;
import com.example.aryasa.drawersayur.Login;
import com.example.aryasa.drawersayur.Model.Userdata;
import com.example.aryasa.drawersayur.Profile;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Adminhomeuser extends Fragment {
//modelnya Userdata
//adapternya adminuseradapater
    private String API_URL = Server.URL + "user";
    ArrayList<Userdata> userdata = new ArrayList<>();
    String token;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.adminhomeuser, container, false);
        final AdminuserAdapter adminuserAdapter = new AdminuserAdapter(view.getContext(),userdata);
        SharedPreferences sharedpreferencesAdmnin = this.getActivity().getSharedPreferences(Login.my_shared_preferences2, Context.MODE_PRIVATE);
        token = "Bearer "+sharedpreferencesAdmnin.getString("token", null);
        getUserApi(API_URL, view, adminuserAdapter);
        return view;
    }


    public void getUserApi(String url, final View view, final AdminuserAdapter sayur){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                    for (int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        if(jsonObject.getString("tipe").equals("user")){
                            userdata.add(new Userdata(jsonObject.getInt("id"),Server.URLIMAGE+jsonObject.getString("foto"), jsonObject.getString("name") ,jsonObject.getString("email"), jsonObject.getString("nomor_telepon")));
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerviewadminhomeuser);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                            recyclerView.setLayoutManager(gridLayoutManager);
                            recyclerView.setAdapter(sayur);
                        }
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
                headers.put("Authorization", token);
                return headers;
            }
        };
        Singleton.getInstance(this.getContext()).addToRequestQueue(jsonArrayRequest);
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
