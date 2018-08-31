package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aryasa.drawersayur.Model.UserInprogress;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Userdetailtransaksi;

import java.util.ArrayList;

public class UserInprogressAdapter extends RecyclerView.Adapter<UserInprogressAdapter.UserInprogressViewHolder> {
    private Context mContext;
    private ArrayList<UserInprogress> mUserInprogress;

    public UserInprogressAdapter(Context mContext, ArrayList<UserInprogress> mUserInprogressList) {
        this.mContext = mContext;
        this.mUserInprogress= mUserInprogressList;
    }

    @Override
    public UserInprogressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_fragment_inprogress, parent, false);
        return new UserInprogressViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final UserInprogressViewHolder holder, final int position) {
        holder.mTanggal.setText(mUserInprogress.get(position).getTextView_tanggal());
        holder.mGambar.setImageResource(R.drawable.transaksi_wait);
        holder.mJam.setText(mUserInprogress.get(position).getStatus());
        holder.mBarang1.setText(mUserInprogress.get(position).getNamauser());
        holder.mBarang2.setText(mUserInprogress.get(position).getNomor());
        holder.mBarang3.setText(mUserInprogress.get(position).getAlamat());
        holder.cView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, Userdetailtransaksi.class);
                mIntent.putExtra("idtransaksi",mUserInprogress.get(position).getIdtransaksi());
                mContext.startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {

        return mUserInprogress.size();
    }

    class UserInprogressViewHolder extends RecyclerView.ViewHolder {


        TextView mBarang1;
        TextView mBarang2;
        TextView mBarang3;
        TextView mTanggal;
        TextView mJam;
        ImageView mGambar;
        CardView cView;

        UserInprogressViewHolder(View itemView) {
            super(itemView);


            mBarang1= itemView.findViewById(R.id.textView_barang1);
            mBarang2 = itemView.findViewById(R.id.textView_barang2);
            mBarang3 = itemView.findViewById(R.id.textView_barang3);
            mJam = itemView.findViewById(R.id.textView_jam);
            mTanggal = itemView.findViewById(R.id.textView_tanggal);
            mGambar = itemView.findViewById(R.id.imageView);
            cView = itemView.findViewById(R.id.carddviewuser);

        }

    }}
