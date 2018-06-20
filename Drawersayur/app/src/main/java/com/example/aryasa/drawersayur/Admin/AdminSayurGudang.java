package com.example.aryasa.drawersayur.Admin;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

public class AdminSayurGudang extends AppCompatActivity {
    private String API_URL = "http://192.168.43.245/api/sayur";
    TextView gudangtext;
    String namaSayur = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayur_gudang);
        setTitle("Stok Sayur Di Gudang");
        gudangtext = (TextView)findViewById(R.id.gudang_textview);

        ArrayList<SayurGudangModel> sayurGudangList = new ArrayList<SayurGudangModel>();

        sayurGudangList.add(new SayurGudangModel("bayam 1", "10000"));
        sayurGudangList.add(new SayurGudangModel("bayam 2", "10000"));
        sayurGudangList.add(new SayurGudangModel("bayam 3", "10000"));
        sayurGudangList.add(new SayurGudangModel("bayam 4", "10000"));
        sayurGudangList.add(new SayurGudangModel("bayam 5", "10000"));

        getSayurApi(API_URL);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerviewsayurgudang);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        SayurGudangAdapter sayurGudangAdapter = new SayurGudangAdapter(AdminSayurGudang.this, sayurGudangList);
        recyclerView.setAdapter(sayurGudangAdapter);


    }

    public void getSayurApi(String url){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
               try{
                   for (int i = 0; i < response.length(); i++){
                       JSONObject jsonObject = response.getJSONObject(i);
                       namaSayur += jsonObject.getString("nama") + " ";
                       gudangtext.setText(namaSayur);
                   }
               }catch (JSONException e){
                    e.printStackTrace();
                    gudangtext.setText("Kurang tepat");
               }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                gudangtext.setText("Tidak Mau");
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/json");
                headers.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImp0aSI6IjJkOGVhOGYxODEzODZmMjUwMGM5N2U2NDk0ZWUxNzQyZDA3OTIxNjJkZWRiYWYzYWQwMDRkZjRiMDZiNDI1NDQyZTJiMjU5N2M1ZTc3MWRhIn0.eyJhdWQiOiIzIiwianRpIjoiMmQ4ZWE4ZjE4MTM4NmYyNTAwYzk3ZTY0OTRlZTE3NDJkMDc5MjE2MmRlZGJhZjNhZDAwNGRmNGIwNmI0MjU0NDJlMmIyNTk3YzVlNzcxZGEiLCJpYXQiOjE1Mjg0NDEzOTAsIm5iZiI6MTUyODQ0MTM5MCwiZXhwIjoxNTU5OTc3MzkwLCJzdWIiOiIyIiwic2NvcGVzIjpbXX0.R5CZQjpgMNSP-mfuGV-MEDa4xBxvjg8dAIg0gz3F9blBuedU5sdBs57j8hU_niXcPC2hEbQX0ZTjn_sX1kqQHVefwZA2l5P1at87TvW8IRngk8jx8MYx_iUxw5RR0zuoPiVRXMvZz3uL8dpA688Nyuqw_54jMHq-WibLKmNVErgf0896FVjTlDDJ7SonHVK1GBOUn1kdtu2oiw3Fl6puXWtaLZsVau9xFKVbBX3j0GxHNzQ6fcInlW59pqhDBM6y-nBq0zJ8QSEwzKqCxxE-egHiXzuTG-LO_qPJx0TjUf8Ly1IrFAskHLeob2z5_e4HEk5H4Z-UIcL3UpzwB_wIRkrCn3FEkKimtRk4DNkNIA39h1JTRKl3tKyHyx5r03VofokiFZe_p6X3CxSFWogqUheHLo2ppY3U5T5vwnoMbRzR_EHa2s8GTjJAdf-k_Bgvbb0HjNLIEJtS1l1Va091fqhBek2tsbFGWfpt5zfG0Mn3kVNPcSIUtW3Go6V6vbvbIRh3gDQndCA4KdRygz5rGNuSNM7abCqewIirWDzzwmfvWR_3YOcZta_l7uGoHF0fyoevmEzBkCAC7n1KXyFeWSL8uCMTmdsdQ2b98BW-0-RIkWcih4sLdUiBBa35fdsHl6eol6Gw-Go-QzdpuXigbpBppeP-g3MoofGdMwR9x-U");
                return headers;
            }
        };

        Singleton.getInstance(this).addToRequestQueue(jsonArrayRequest);
    }
}
