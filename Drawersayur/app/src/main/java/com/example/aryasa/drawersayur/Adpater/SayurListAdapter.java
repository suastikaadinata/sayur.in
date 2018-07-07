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

import com.example.aryasa.drawersayur.Model.SayurListModel;
import com.example.aryasa.drawersayur.R;



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
    public void onBindViewHolder(SayurlistViewHolder holder, int position) {
        holder.mImage.setImageResource(mSayurlist.get(position).getGambar_sayur_admin_list());
        holder.mTitle.setText(mSayurlist.get(position).getNama_sayur_admin_list());
        holder.mHarga.setText(mSayurlist.get(position).getHarga_sayur_admin_list());
        //holder.mCardView.

    }

    class SayurlistViewHolder extends RecyclerView.ViewHolder{
        ImageView mImage;
        TextView mHarga;
        TextView mTitle;
        CardView mCardView;
        ToggleButton mToggle;

        public SayurlistViewHolder(View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.gambar_sayur_admin_list);
            mTitle = itemView.findViewById(R.id.nama_sayur_admin_list);
            mHarga = itemView.findViewById(R.id.harga_sayur_admin_list);
            mCardView = itemView.findViewById(R.id.cardviewadminlist);
            //mToggle = itemView.findViewById(R.id.toggle);
        }
    }
}
