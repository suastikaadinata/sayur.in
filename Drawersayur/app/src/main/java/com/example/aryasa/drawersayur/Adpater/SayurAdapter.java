package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import java.util.ArrayList;

public class SayurAdapter extends RecyclerView.Adapter<SayurAdapter.SayurViewHolder> {

    private Context mContext;
    private ArrayList<Sayur> mSayurlist;
    private Callbacks callbacks;
    int jumlah, updatebottom;

    int harga, total=0;

    public void total(int harga){
        total = total+harga;
    }
    public void kurangtotal(int harga){
        total = total-harga;
    }


    public SayurAdapter(Context mContext, ArrayList<Sayur> mSayurlist, Callbacks callbacks) {
        this.callbacks = callbacks;
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
    public void onBindViewHolder(final SayurViewHolder holder, final int position) {

        ImageLoader imageLoader = Singleton.getInstance(mContext).getImageLoader();
        imageLoader.get(mSayurlist.get(position).getFoto(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.mImage.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        holder.mTitle.setText(mSayurlist.get(position).getNama());
        holder.mHarga.setText(String.valueOf(mSayurlist.get(position).getId()));
        holder.mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total(mSayurlist.get(position).getHarga());
                callbacks.updateharga(total);
                callbacks.updateCart(mSayurlist.get(position));
                holder.mButtonAdd.setVisibility(View.INVISIBLE);
                holder.mLayoutKuantitas.setVisibility(View.VISIBLE);

            }
        });
        holder.mTambahQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                total(mSayurlist.get(position).getHarga());
                callbacks.updateharga(total);
                jumlah = Integer.parseInt(holder.mTextQ.getText().toString());
                holder.mTextQ.setText(String.valueOf(jumlah+1));
                callbacks.updateJumlah(Integer.parseInt(holder.mTextQ.getText().toString()));
            }
        });
        holder.mKurangQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlah = Integer.parseInt(holder.mTextQ.getText().toString());
                if(jumlah<=1){
                    jumlah=0;
                    holder.mLayoutKuantitas.setVisibility(View.INVISIBLE);
                    holder.mButtonAdd.setVisibility(View.VISIBLE);
                    kurangtotal(mSayurlist.get(position).getHarga());
                    callbacks.updateharga(total);

                }else {
                    kurangtotal(mSayurlist.get(position).getHarga());
                    callbacks.updateharga(total);
                    jumlah = Integer.parseInt(holder.mTextQ.getText().toString());
                    holder.mTextQ.setText(String.valueOf(--jumlah));

                }
            }
        });


    }

    class SayurViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mHarga, mTextQ;
        TextView mTitle;
        CardView mCardView;
        Button mButtonAdd, mTambahQ, mKurangQ;
        LinearLayout mLayoutKuantitas;

        public SayurViewHolder(View itemView) {
            super(itemView);
            mButtonAdd = itemView.findViewById(R.id.button_tambah_sayur);
            mImage = itemView.findViewById(R.id.gambar_sayur);
            mTitle = itemView.findViewById(R.id.nama_sayur);
            mHarga = itemView.findViewById(R.id.harga_sayur);
            mCardView = itemView.findViewById(R.id.cradview);
            mTextQ = itemView.findViewById(R.id.tV_jumlahSayur);
            mTambahQ = itemView.findViewById(R.id.buttonPlus);
            mKurangQ = itemView.findViewById(R.id.buttonMinus);
            mLayoutKuantitas = itemView.findViewById(R.id.LayoutQ);
            mLayoutKuantitas.setVisibility(View.INVISIBLE);
            if(mTextQ.getText().equals("0")){
                mLayoutKuantitas.setVisibility(View.INVISIBLE);
            }

        }
    }
}
