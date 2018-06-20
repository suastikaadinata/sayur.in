package com.example.aryasa.drawersayur.Adpater;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.aryasa.drawersayur.Model.SayurGudangModel;
import com.example.aryasa.drawersayur.R;

import java.util.ArrayList;

public class SayurGudangAdapter extends RecyclerView.Adapter<SayurGudangAdapter.SayurGudangViewHolder> {
    private Context context;
    private ArrayList<SayurGudangModel> sayurGudangList;

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
    public void onBindViewHolder(SayurGudangViewHolder holder, int position) {
        holder.mNama.setText(sayurGudangList.get(position).getNama());
        holder.mHarga.setText(sayurGudangList.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return sayurGudangList.size();
    }

    public class SayurGudangViewHolder extends RecyclerView.ViewHolder {
        TextView mHarga;
        TextView mNama;
        CardView mCardView;

        public SayurGudangViewHolder(View view){
            super(view);
            mNama = view.findViewById(R.id.nama_sayurgudang);
            mHarga = view.findViewById(R.id.harga_sayurgudang);
            mCardView = view.findViewById(R.id.cradview_sayurgudang);
        }
    }
}
