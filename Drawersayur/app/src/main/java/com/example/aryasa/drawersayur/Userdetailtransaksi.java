package com.example.aryasa.drawersayur;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Adpater.Adapterusertransaksi;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Userdetailtransaksi extends AppCompatActivity {
    String iduser,idtransaksi, tanggalkirim, alamat, namauser, telpuser,status;
    private TextView Txtanggalkirim, Txalamat,txTotalharga,txOngkir,txTotal,TxUser,TxTelp;
    private Adapterusertransaksi adapter;
    private String API_TRANSAKSI = Server.URL + "transaksi/list/detail";
    Button btn_lihat_map;
    private RecyclerView mList;
    int totalharga,ongkir;
    private Fragment fragment;
    ArrayList<Sayur> listKeranjang = new ArrayList<Sayur>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetail_transaksi);
        ongkir=3000;
        Txalamat =(TextView) findViewById(R.id.textView_Lokasi);
        Txtanggalkirim = (TextView) findViewById(R.id.textViewTanggal);
        txTotalharga = (TextView) findViewById(R.id.textViewhargabarang2);
        txOngkir = (TextView) findViewById(R.id.textViewbiayapengiriman2);
        txTotal = (TextView) findViewById(R.id.textViewTotal2);
        txOngkir.setText("Rp. "+String.valueOf(ongkir));
        TxUser= (TextView) findViewById(R.id.TextviewUser);
        TxTelp = (TextView)findViewById(R.id.TextviewTelp);

        idtransaksi = getIntent().getExtras().getString("idtransaksi");
        btn_lihat_map = (Button) findViewById(R.id.buttonmap);
        btn_lihat_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Userdetailtransaksi.this, MapsDirection.class);
                startActivity(intent);
            }
        });

        adapter = new Adapterusertransaksi(this,listKeranjang);
        ambilkeranjang(API_TRANSAKSI,adapter);

    }
    private void loadFragment(android.support.v4.app.Fragment fragment) {
        // load fragment
        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameLayoutDrawer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    private void ambilkeranjang (String url, final Adapterusertransaksi keranjang){
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
                        listKeranjang.add(new Sayur(Server.URLIMAGE + jsonobject.getString("foto"), jsonobject.getInt("sayur_id"),
                                jsonobject.getString("nama"), jsonobject.getInt("harga"), jsonobject.getInt("jumlah_sayur")));
                        mList = (RecyclerView) findViewById(R.id.detailtransaksi);
                        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        mList.setLayoutManager(mLayoutManager);
                        mList.setAdapter(keranjang);
                        tanggalkirim = jsonobject.getString("waktu_pengiriman");
                        alamat = jsonobject.getString("alamat");
                        namauser = jsonobject.getString("name");
                        telpuser = jsonobject.getString("nomor_telepon");
                        totalharga = totalharga + jsonobject.getInt("total_harga");
                        status = jsonobject.getString("status_transaksi");
                    }
                    txTotalharga.setText("Rp. "+String.valueOf(totalharga));
                    txTotal.setText("Rp. "+String.valueOf(totalharga+ongkir));
                    Txalamat.setText(alamat);
                    Txtanggalkirim.setText(tanggalkirim);
                    TxUser.setText("Nama  : " +namauser);
                    TxTelp.setText("Nomor : " +telpuser);

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
                params.put("id",idtransaksi);
                return params;
            }
        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}
