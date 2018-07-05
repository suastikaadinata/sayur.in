package com.example.aryasa.drawersayur.Adpater;

import android.content.ClipData;
import android.content.Context;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.aryasa.drawersayur.Model.SayurGudangModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import java.util.ArrayList;

public class SayurGudangAdapter extends RecyclerView.Adapter<SayurGudangAdapter.SayurGudangViewHolder> {
    private Context context;
    private ArrayList<SayurGudangModel> sayurGudangList;
    private String API_URL = "http://10.0.3.2/api/sayur";

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
    public void onBindViewHolder(final SayurGudangViewHolder holder, int position) {
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

        public SayurGudangViewHolder(View view){
            super(view);
            mFoto = view.findViewById(R.id.gambar_sayurgudang);
            mNama = view.findViewById(R.id.nama_sayurgudang);
            mHarga = view.findViewById(R.id.harga_sayurgudang);
            mCardView = view.findViewById(R.id.cradview_sayurgudang);
        }
    }

    public void clear(){
        sayurGudangList.clear();
        notifyDataSetChanged();
    }

}
