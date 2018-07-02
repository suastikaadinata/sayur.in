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
    private String API_URL = "http://10.0.2.2/api/sayur";
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
                       sayurGudangList.add(new SayurGudangModel("http://10.0.2.2/img/"+jsonObject.getString("foto") ,jsonObject.getString("nama"), jsonObject.getInt("harga")));
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
                headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aS" +
                        "I6ImMwOGE3M2NiZWU0Y2I3MTY3ZGM5ZGE1ZTg0ZDZhODMyMWFjZmIxZmMyZDhhZDlmMTI5MmV" +
                        "jNmRkYmQ2NTBkMWEyNTYyNWMyN2ZhNjM2YjNkIn0.eyJhdWQiOiIzIiwianRpIjoiYzA4YTczY2J" +
                        "lZTRjYjcxNjdkYzlkYTVlODRkNmE4MzIxYWNmYjFmYzJkOGFkOWYxMjkyZWM2ZGRiZDY1MGQxYTI1Nj" +
                        "I1YzI3ZmE2MzZiM2QiLCJpYXQiOjE1MzAyMzc1NDgsIm5iZiI6MTUzMDIzNzU0OCwiZXhwIjoxNTYxNzc" +
                        "zNTQ4LCJzdWIiOiIzIiwic2NvcGVzIjpbXX0.Ej8YAs6EgUUX-H4vZhVWibByvycquRffZV1GBca3EL7QTZ" +
                        "RG4WLBEKct6WUYhSsCkng7hg5MN3KqluLLghSBr6zEZl61aeGbiGiB2aRtmIECvSAU7_xPmJXgO2NuCUhz" +
                        "s-ZnTcZEe9wnnQ4_Z6IV3_ioQlVij2Z7ASJ6bgGH4V1R_-NMJ60HQGJ6p2B9bcoD-5KjAjSpAzMSTu38CM" +
                        "iDNZkAS_DT-eH9JM4WQyg3-jmQGUdDArctqsmsyYsQapFPifeo5qUtx5X4aM3hhVKOQqLexSy4yqoq6FYu" +
                        "YTahzjFbgfaszJsslgeMf5grotIDAreYPuSYr_pJnJNNXQnBnSxJDNs5CbZU80LfEgzaUGtFgzUletVUu8" +
                        "xpgCuG9XIpCHXA2JJ56R4VsOwXypqfRhbJ6TQJTfuxM9RzivmjN5fOkYuGDs-jTjDRWb5vW5boOUk0Pp3N" +
                        "oOmB9fTfpQhARZNHOFRghpqN04IIvIHUfuMqG_MOgAg4T2oGse-_gcqOvs0r45nlTIldavEcYz6LBeftjN" +
                        "o1Z7ARCeSQiqMtEChbxjquuiIDUt2QKVyWgsQle2kU7" +
                        "SJcMrH_4G1SaXCbB926Ii8Y12zAM9viJOZ6DDP1moDRI7iFqq49RlM4jC4qoReBb2DLiw0znf7nr8Y0TFcIQG_B6gfbRxYFAX9OgMY");
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
