package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.aryasa.drawersayur.Admin.Adminubahsayur;
import com.example.aryasa.drawersayur.Model.SayurListModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Singleton.Singleton;


import java.util.ArrayList;

public class SayurListAdapter extends RecyclerView.Adapter<SayurListAdapter.SayurlistViewHolder> {
    private Context mContext;
    private ArrayList<SayurListModel> mSayurlist;
    View mView;

    public SayurListAdapter(Context mContext, ArrayList<SayurListModel> mSayurlist) {
        this.mContext = mContext;
        this.mSayurlist = mSayurlist;
    }
    @Override
    public SayurlistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sayur_admin_list_row, parent, false);
        SayurlistViewHolder vh = new SayurlistViewHolder(mView); // pass the view to View Holder
        return vh;
    }

    @Override
    public int getItemCount() {
        return mSayurlist.size();
    }

    @Override
    public void onBindViewHolder(final SayurlistViewHolder holder, int position) {
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
        holder.mHarga.setText(String.valueOf(mSayurlist.get(position).getHarga()));

        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, Adminubahsayur.class);
                mIntent.putExtra("nama", mSayurlist.get(holder.getAdapterPosition()).getNama());
                mIntent.putExtra("harga", (String.valueOf(mSayurlist.get(holder.getAdapterPosition()).getHarga())));
                mIntent.putExtra("gambar", mSayurlist.get(holder.getAdapterPosition()).getFoto());
                mContext.startActivity(mIntent);
            }
        });

    }

    class SayurlistViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mHarga;
        TextView mTitle;
        CardView mCardView;
        Button Edit;

        public SayurlistViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.gambar_sayur_admin_list);
            mTitle = itemView.findViewById(R.id.nama_sayur_admin_list);
            mHarga = itemView.findViewById(R.id.harga_sayur_admin_list);
            mCardView = itemView.findViewById(R.id.cardviewadminlist);
            Edit =itemView.findViewById(R.id.btn_edit_sayur_admin_list);
            //mToggle = itemView.findViewById(R.id.toggle);
        }
    }
}
