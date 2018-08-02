package com.example.aryasa.drawersayur.Adpater;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Admin.AdminHome;
import com.example.aryasa.drawersayur.Admin.AdminSayurGudang;
import com.example.aryasa.drawersayur.Admin.Admintambahsayur;
import com.example.aryasa.drawersayur.Admin.Adminubahsayur;
import com.example.aryasa.drawersayur.Admin.Adminviewuser;
import com.example.aryasa.drawersayur.Model.SayurGudangModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SayurGudangAdapter extends RecyclerView.Adapter<SayurGudangAdapter.SayurGudangViewHolder> {
    private Context context;
    private ArrayList<SayurGudangModel> sayurGudangList;
    private String API_URL = Server.URL + "sayur";

    public SayurGudangAdapter(Context context, ArrayList<SayurGudangModel> sayurGudangList){
        this.context = context;
        this.sayurGudangList = sayurGudangList;
    }

    @Override
    public SayurGudangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sayur_gudang_row, parent, false);
        SayurGudangViewHolder vh = new SayurGudangViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final SayurGudangViewHolder holder, final int position) {
        holder.mNama.setText(sayurGudangList.get(position).getNama());
        holder.mHarga.setText(String.valueOf(sayurGudangList.get(position).getHarga()));

        ImageLoader imageLoader = Singleton.getInstance(context).getImageLoader();
        imageLoader.get(sayurGudangList.get(position).getFoto(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.mFoto.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        holder.btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(context, String.valueOf((sayurGudangList.get(position).getId())));
            }
        });

    }
    private void showDialog(final Context context, final String idSayur){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title dialog
        alertDialogBuilder.setTitle("Tambah ");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk Tambah!")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL + "/tambah-sayur", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Intent mIntent = new Intent(context, AdminHome.class);
                                context.startActivity(mIntent);
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
                                headers.put("Authorization", Server.TOKEN);
                                return headers;
                            }

                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                HashMap<String, String> params = new HashMap<>();
                                params.put("id", idSayur);
                                return params;
                            }
                        };

                        Singleton.getInstance(context).addToRequestQueue(stringRequest);
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }


    @Override
    public int getItemCount() {
        return sayurGudangList.size();
    }

    public class SayurGudangViewHolder extends RecyclerView.ViewHolder {
        TextView mHarga;
        TextView mNama;
        CardView mCardView;
        ImageView mFoto;
        Button btn_add;

        public SayurGudangViewHolder(View view){
            super(view);
            mFoto = view.findViewById(R.id.gambar_sayurgudang);
            mNama = view.findViewById(R.id.nama_sayurgudang);
            mHarga = view.findViewById(R.id.harga_sayurgudang);
            mCardView = view.findViewById(R.id.cradview_sayurgudang);
            btn_add = view.findViewById(R.id.btn_add_sayur_admin);

        }
    }

    public void clear(){
        sayurGudangList.clear();
        notifyDataSetChanged();
    }

}
