package com.example.aryasa.drawersayur.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Adpater.Checkout;
import com.example.aryasa.drawersayur.MapsDirection;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Admindetailtransaksi extends AppCompatActivity {
    String iduser,idtransaksi;
    private Checkout adapter;
    private String API_TRANSAKSI = Server.URL + "transaksi/list/detail";
    Button btn_lihat_map;
    private RecyclerView mList;
    ArrayList<Sayur> listKeranjang = new ArrayList<Sayur>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindetailtransaksi);
        idtransaksi = getIntent().getExtras().getString("idtransaksi");
        iduser = getIntent().getExtras().getString("iduser");
        btn_lihat_map = (Button) findViewById(R.id.buttonmap);
        btn_lihat_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admindetailtransaksi.this, MapsDirection.class);
                startActivity(intent);
            }
        });
        adapter = new Checkout(this,listKeranjang);
        ambilkeranjang(API_TRANSAKSI,adapter);

    }
    private void ambilkeranjang (String url, final Checkout keranjang){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String json = response.toString();
                Log.e("Response:", response.toString());
                listKeranjang.clear();
                try {
                    JSONArray jsonArray = new JSONArray(json);
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject jsonobject = jsonArray.getJSONObject(i);
                        if (jsonobject.getString("transaksi_id").equals(idtransaksi)){
                            listKeranjang.add(new Sayur(jsonobject.getInt("sayur_id"),jsonobject.getInt("jumlah")));
                            mList = (RecyclerView) findViewById(R.id.recyclerview_checkout);
                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mList.setLayoutManager(mLayoutManager);
                            mList.setAdapter(keranjang);
                        }
                    }
                } catch (Exception e) {
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
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", iduser);
                return params;
            }
        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}
