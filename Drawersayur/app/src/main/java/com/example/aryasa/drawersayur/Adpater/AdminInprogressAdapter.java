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

import com.example.aryasa.drawersayur.Admin.Admindetailtransaksi;
import com.example.aryasa.drawersayur.Model.AdminInprogress;
import com.example.aryasa.drawersayur.R;

import java.util.ArrayList;

public class AdminInprogressAdapter extends RecyclerView.Adapter<AdminInprogressAdapter.AdminInprogressViewHolder> {
    private Context mContext;
    private ArrayList<AdminInprogress> mAdminInprogress;

    public AdminInprogressAdapter(Context mContext, ArrayList<AdminInprogress> mAdminInprogressList) {
        this.mContext = mContext;
        this.mAdminInprogress= mAdminInprogressList;
    }

    @Override
    public AdminInprogressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_admin_history_inprogress, parent, false);
        return new AdminInprogressViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final AdminInprogressViewHolder holder, final int position) {
        holder.mTanggal.setText(mAdminInprogress.get(position).getTextView_tanggal());
        holder.mGambar.setImageResource(R.drawable.transaksi_wait);
        holder.mJam.setText(mAdminInprogress.get(position).getStatus());
        holder.mBarang1.setText(mAdminInprogress.get(position).getNamauser());
        holder.mBarang2.setText(mAdminInprogress.get(position).getNomor());
        holder.mBarang3.setText(mAdminInprogress.get(position).getAlamat());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, Admindetailtransaksi.class);
                mIntent.putExtra("idtransaksi",mAdminInprogress.get(position).getIdtransaksi());
                mContext.startActivity(mIntent);
            }
        });



    }
    @Override
    public int getItemCount() {

        return mAdminInprogress.size();
    }

    class AdminInprogressViewHolder extends RecyclerView.ViewHolder {


        TextView mBarang1;
        TextView mBarang2;
        TextView mBarang3;
        TextView mTanggal;
        TextView mJam;
        ImageView mGambar;
        CardView mCardView;

        AdminInprogressViewHolder(View itemView) {
            super(itemView);


            mBarang1= itemView.findViewById(R.id.textView_barang1);
            mBarang2 = itemView.findViewById(R.id.textView_barang2);
            mBarang3 = itemView.findViewById(R.id.textView_barang3);
            mJam = itemView.findViewById(R.id.textView_jam);
            mTanggal = itemView.findViewById(R.id.textView_tanggal);
            mGambar = itemView.findViewById(R.id.imageView);
            mCardView = itemView.findViewById(R.id.card_admin_inprogress);

        }

    }}

