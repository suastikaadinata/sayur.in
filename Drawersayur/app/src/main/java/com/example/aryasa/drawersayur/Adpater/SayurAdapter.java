package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Sayur;

import java.util.ArrayList;

public class SayurAdapter extends RecyclerView.Adapter<SayurAdapter.SayurViewHolder> {
    private Context mContext;
    private ArrayList<Sayur> mSayurlist;
    View mView;

    public SayurAdapter(Context mContext, ArrayList<Sayur> mSayurlist) {
        this.mContext = mContext;
        this.mSayurlist = mSayurlist;
    }
    @Override
    public SayurViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleritem_row, parent, false);
        SayurViewHolder vh = new SayurViewHolder(mView); // pass the view to View Holder
        return vh;
    }

    @Override
    public int getItemCount() {
        return mSayurlist.size();
    }

    @Override
    public void onBindViewHolder(SayurViewHolder holder, int position) {
        holder.mImage.setImageResource(mSayurlist.get(position).getGambar_sayur());
        holder.mTitle.setText(mSayurlist.get(position).getNama_sayur());
        holder.mHarga.setText(mSayurlist.get(position).getHarga_sayur());
        //holder.mCardView.

    }

    class SayurViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mHarga;
        TextView mTitle;
        CardView mCardView;
        ToggleButton mToggle;

        public SayurViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.gambar_sayur);
            mTitle = itemView.findViewById(R.id.nama_sayur);
            mHarga = itemView.findViewById(R.id.harga_sayur);
            mCardView = itemView.findViewById(R.id.cradview);
            //mToggle = itemView.findViewById(R.id.toggle);
        }
    }
}
