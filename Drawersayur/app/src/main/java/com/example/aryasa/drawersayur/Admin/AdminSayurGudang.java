package com.example.aryasa.drawersayur.Admin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Adpater.SayurGudangAdapter;
import com.example.aryasa.drawersayur.Login;
import com.example.aryasa.drawersayur.Model.SayurGudangModel;
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

public class AdminSayurGudang extends Fragment {
    private String API_URL = Server.URL + "sayur";
    private String API_URL_Search = Server.URL + "sayur/gudang/search";;
    ArrayList<SayurGudangModel> sayurGudangList = new ArrayList<SayurGudangModel>();
    SwipeRefreshLayout swipeRefreshLayout;
    final Context context = this.getContext();
    private SayurGudangAdapter sayurGudangAdapter;
    String token;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.activity_sayur_gudang, container, false);
        swipeRefreshLayout = view.findViewById(R.id.swipecontainer);
        sayurGudangAdapter = new SayurGudangAdapter(view.getContext(), sayurGudangList);
        getSayurApi(API_URL, view, sayurGudangAdapter);
        SharedPreferences sharedpreferencesAdmnin = this.getActivity().getSharedPreferences(Login.my_shared_preferences2, Context.MODE_PRIVATE);
        token = "Bearer "+sharedpreferencesAdmnin.getString("token", null);
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
                       sayurGudangList.add(new SayurGudangModel(jsonObject.getInt("id") ,Server.URLIMAGE+jsonObject.getString("foto") ,jsonObject.getString("nama"), jsonObject.getInt("harga")));
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
                headers.put("Authorization", token);
                return headers;
            }


        };
        Singleton.getInstance(this.getContext()).addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.admin_action_bar_gudang, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setIconified(true);

        super.onCreateOptionsMenu(menu,inflater);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                cariData(newText, context);
                return false;
            }
        });
    }

    private void cariData(final String keyword, final Context context ) {
        StringRequest SearchReq = new StringRequest(Request.Method.POST, API_URL_Search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response){
                        String json = response.toString();
                        Log.e("Response: ", response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            sayurGudangList.clear();
                            sayurGudangAdapter.notifyDataSetChanged();

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObjectArray = jsonArray.getJSONObject(i);
                                sayurGudangList.add(new SayurGudangModel(jsonObjectArray.getInt("id") ,Server.URLIMAGE+jsonObjectArray.getString("foto") ,jsonObjectArray.getString("nama"), jsonObjectArray.getInt("harga")));
                                sayurGudangAdapter.notifyDataSetChanged();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){

            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/json");
                headers.put("Authorization", token);
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("keyword",keyword);
                return map;
            }
        };
        Singleton.getInstance(context).addToRequestQueue(SearchReq);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
