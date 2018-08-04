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

import com.example.aryasa.drawersayur.Admin.Adminubahsayur;
import com.example.aryasa.drawersayur.Admin.Adminviewuser;
import com.example.aryasa.drawersayur.Model.UserCompleted;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Model.Userdata;

import java.util.List;

public class UserCompletedAdapter extends RecyclerView.Adapter<UserCompletedAdapter.UserCompletedViewHolder> {
    private Context mContext;
    private List<UserCompleted> mUserCompleted;

    public UserCompletedAdapter(Context mContext, List<UserCompleted> mUserCompletedList) {
        this.mContext = mContext;
        this.mUserCompleted= mUserCompletedList;
    }

    @Override
    public UserCompletedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_fragment_completed, parent, false);
        return new UserCompletedViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final UserCompletedViewHolder holder, int position) {
        holder.mBarang1.setText(mUserCompleted.get(position).getTextView_barang1());
        holder.mBarang2.setText(mUserCompleted.get(position).getTextView_barang2());
        holder.mBarang3.setText(mUserCompleted.get(position).getTextView_barang3());
        holder.mTanggal.setText(mUserCompleted.get(position).getTextView_tanggal());
        holder.mJam.setText(mUserCompleted.get(position).getTextView_jam());
        holder.mGambar.setImageResource(mUserCompleted.get(position).getImageView());

    }
    @Override
    public int getItemCount() {

        return mUserCompleted.size();
    }

    class UserCompletedViewHolder extends RecyclerView.ViewHolder {


        TextView mBarang1;
        TextView mBarang2;
        TextView mBarang3;
        TextView mTanggal;
        TextView mJam;
        ImageView mGambar;

        UserCompletedViewHolder(View itemView) {
            super(itemView);


            mBarang1= itemView.findViewById(R.id.textView_barang1);
            mBarang2 = itemView.findViewById(R.id.textView_barang2);
            mBarang3 = itemView.findViewById(R.id.textView_barang3);
            mJam = itemView.findViewById(R.id.textView_jam);
            mTanggal = itemView.findViewById(R.id.textView_tanggal);
            mGambar = itemView.findViewById(R.id.imageView);

        }

    }}