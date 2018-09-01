package com.example.aryasa.drawersayur.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Adpater.Adapterdetailtransaksi;
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
    String iduser,idtransaksi, tanggalkirim, alamat, namauser, telpuser,status;
    private TextView Txtanggalkirim, Txalamat,txTotalharga,txOngkir,txTotal,TxUser,TxTelp,TxUbah;
    private Adapterdetailtransaksi adapter;
    private String API_TRANSAKSI = Server.URL + "transaksi/list/detail";
    private String API_UbahComplete = Server.URL + "transaksi/complete";
    private String API_UbahDelivery = Server.URL + "transaksi/onDelivery";
    Button btn_lihat_map, btnDelivery, btnComplete;
    private RecyclerView mList;
    private CardView cView;
    int totalharga,ongkir;
    private Fragment fragment;

    ArrayList<Sayur> listKeranjang = new ArrayList<Sayur>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindetailtransaksi);
        ongkir=3000;
        Txalamat =(TextView) findViewById(R.id.textView_Lokasi);
        Txtanggalkirim = (TextView) findViewById(R.id.textViewTanggal);
        txTotalharga = (TextView) findViewById(R.id.textViewhargabarang2);
        txOngkir = (TextView) findViewById(R.id.textViewbiayapengiriman2);
        txTotal = (TextView) findViewById(R.id.textViewTotal2);
        txOngkir.setText("Rp. "+String.valueOf(ongkir));
        TxUser= (TextView) findViewById(R.id.TextviewUser);
        TxTelp = (TextView)findViewById(R.id.TextviewTelp);
        btnDelivery =(Button) findViewById(R.id.buttonDelivery);
        btnComplete =(Button) findViewById(R.id.buttonSelesai);
        TxUbah =(TextView)findViewById(R.id.textUbahStatus) ;
        cView =(CardView)findViewById(R.id.layoutUbah);


        cView.setVisibility(View.GONE);
        idtransaksi = getIntent().getExtras().getString("idtransaksi");
        btn_lihat_map = (Button) findViewById(R.id.buttonmap);
        btn_lihat_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admindetailtransaksi.this, MapsDirection.class);
                intent.putExtra("data1", Txalamat.getText().toString());
                startActivity(intent);
            }
        });

        adapter = new Adapterdetailtransaksi(this,listKeranjang);
        ambilkeranjang(API_TRANSAKSI,adapter);

        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UbahstatusCom(API_UbahComplete);
            }
        });
        btnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UbahstatusDeliv(API_UbahDelivery);
            }
        });



    }

    private void UbahstatusCom(String url) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String json = response.toString();
                try {
                    Toast.makeText(getApplicationContext(),"Berhasil diubah",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), AdminHome.class));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                if(error!=null && error.getMessage() !=null){
                    Toast.makeText(getApplicationContext(),"error VOLLEY "+error.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("transaksi_id", String.valueOf(idtransaksi));
                return params;
            }

        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);

    }
    private void UbahstatusDeliv(String url) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String json = response.toString();
                try {
                    Toast.makeText(getApplicationContext(),"Berhasil diubah",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), AdminHome.class));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                if(error!=null && error.getMessage() !=null){
                    Toast.makeText(getApplicationContext(),"error VOLLEY "+error.getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("transaksi_id", String.valueOf(idtransaksi));
                return params;
            }
        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);

    }

    private void ambilkeranjang (String url, final Adapterdetailtransaksi keranjang){
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
                    if (status.equals("0")){
                        cView.setVisibility(View.VISIBLE);
                    }if (status.equals("1")){
                        cView.setVisibility(View.VISIBLE);
                        btnDelivery.setVisibility(View.GONE);
                    }if (status.equals("2")){
                        TxUbah.setText("Transaksi Selesai");
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
                params.put("id", idtransaksi);
                return params;
            }
        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);
    }

}
