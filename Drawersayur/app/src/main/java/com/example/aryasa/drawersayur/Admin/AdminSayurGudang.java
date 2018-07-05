package com.example.aryasa.drawersayur.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.aryasa.drawersayur.Adpater.SayurGudangAdapter;
import com.example.aryasa.drawersayur.Model.SayurGudangModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdminSayurGudang extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private String API_URL = "http://10.0.3.2/api/sayur";
    ArrayList<SayurGudangModel> sayurGudangList = new ArrayList<SayurGudangModel>();
    SwipeRefreshLayout swipeRefreshLayout;
    SayurGudangAdapter sayurGudangAdapter = new SayurGudangAdapter(AdminSayurGudang.this, sayurGudangList);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayur_gudang);
        setTitle("Stok Sayur Di Gudang");
        swipeRefreshLayout = findViewById(R.id.swipecontainer);

        getSayurApi(API_URL);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                        sayurGudangAdapter.clear();
                        getSayurApi(API_URL);
                    }
                }, 1000);
            }
        });
    }

    public void getSayurApi(String url){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               try{
                   for (int i = 0; i < response.length(); i++){
                       JSONObject jsonObject = response.getJSONObject(i);
                       sayurGudangList.add(new SayurGudangModel("http://10.0.3.2/img/"+jsonObject.getString("foto") ,jsonObject.getString("nama"), jsonObject.getInt("harga")));
                       RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerviewsayurgudang);
                       GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
                       recyclerView.setLayoutManager(gridLayoutManager);
                       recyclerView.setAdapter(sayurGudangAdapter);
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
                headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjIwOThhMTA5Yjc1OTNiOTM4ZmU5OTE3OTY4YjY0YjQzYTc5MmJmZjQ0OGEzZTIwZGMyNjhhMjliZGU3YjU2MmU2ZWE0YTliNjcwZmE4NGUwIn0.eyJhdWQiOiIxIiwianRpIjoiMjA5OGExMDliNzU5M2I5MzhmZTk5MTc5NjhiNjRiNDNhNzkyYmZmNDQ4YTNlMjBkYzI2OGEyOWJkZTdiNTYyZTZlYTRhOWI2NzBmYTg0ZTAiLCJpYXQiOjE1MzA1MDExODAsIm5iZiI6MTUzMDUwMTE4MCwiZXhwIjoxNTYyMDM3MTgwLCJzdWIiOiI1Iiwic2NvcGVzIjpbXX0.jkJMJoOR4lkjR9PUSF5WVXCacJzC1ykvEY-yChSgWkt_wLbkj9_-gdqChcr1eQ8P7XY6fZ9qs-sAKWg7A4-mAllziTLhj_DDq80EXzzaPPpi1XHpjZk9AN73qObv6U76t3zYLrXGK73UlBM-H2ySgWjO0X7ZXjtUujyTQhOeDYEF-JhEzhKl9HobVP7KpYaUrNYIOYh2ZY1ziu9-3amafNyYSegtrh4_32WNQz7lsjpfnE0M57x-HV75v65cqJWTrOc0o-EMjdB9kI3_d2OVgmWBxOxTYaze8JA51cxfRnoRrfkm49xEbmUB0m-iXVb7qjzq1aNB_iV7ng6d4WdCw7JrHes6RL03lHPV2_vgyr6x9meVwpYQUwnJV1zXR4FEY357OFoFQ02AqkotNC50-udA-DfLLMB8X0-OGZxeyX6n0OKvXmZaFv0rouSVnvzcHJm7vBNZhm9PcmjoldPDHS-zMhh4sa-z1Vdtw6_5IepZwq3W0pErQe6qybAaJ__iN4hL40JwxuH6crXEJcu5Jpqz047Gz_p_IYDLXL05r0Qvhz2_nsQ9MjNBBou_P_OxPF-gvPje8RmDoOfzkE0cC4DrQv0oxW8NSKLEsyYAJaZ0FYQF9jW7fGayvEeuiUYc81vIwdA7Ddljtwk4BteVzRbPzxsILV_NPwHFRZ3yBbw");
                return headers;
            }
        };
        Singleton.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_action_bar, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
