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
import com.example.aryasa.drawersayur.Model.AdminCompleted;
import com.example.aryasa.drawersayur.R;

import java.util.List;

public class AdminCompletedAdapter extends RecyclerView.Adapter<AdminCompletedAdapter.AdminCompletedViewHolder> {
    private Context mContext;
    private List<AdminCompleted> mAdminCompleted;

    public AdminCompletedAdapter(Context mContext, List<AdminCompleted> mAdminCompletedList) {
        this.mContext = mContext;
        this.mAdminCompleted= mAdminCompletedList;
    }

    @Override
    public AdminCompletedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_admin_history_completed, parent, false);
        return new AdminCompletedViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final AdminCompletedViewHolder holder, final int position) {
        holder.mTanggal.setText(mAdminCompleted.get(position).getTextView_tanggal());
        holder.mGambar.setImageResource(R.drawable.ic_broccoli_vegetable_silhouette);
        holder.mJam.setText(mAdminCompleted.get(position).getStatus());
        holder.mBarang1.setText(mAdminCompleted.get(position).getNama());
        holder.mBarang2.setText(mAdminCompleted.get(position).getNomor());
        holder.mBarang3.setText(mAdminCompleted.get(position).getAlamat());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, Admindetailtransaksi.class);
                mIntent.putExtra("idtransaksi",mAdminCompleted.get(position).getIdtransaksi());
                mContext.startActivity(mIntent);
            }
        });

    }
    @Override
    public int getItemCount() {

        return mAdminCompleted.size();
    }

    class AdminCompletedViewHolder extends RecyclerView.ViewHolder {


        TextView mBarang1;
        TextView mBarang2;
        TextView mBarang3;
        TextView mTanggal;
        TextView mJam;
        ImageView mGambar;
        CardView mCardView;

        AdminCompletedViewHolder(View itemView) {
            super(itemView);


            mBarang1= itemView.findViewById(R.id.textView_barang1);
            mBarang2 = itemView.findViewById(R.id.textView_barang2);
            mBarang3 = itemView.findViewById(R.id.textView_barang3);
            mJam = itemView.findViewById(R.id.textView_jam);
            mTanggal = itemView.findViewById(R.id.textView_tanggal);
            mGambar = itemView.findViewById(R.id.imageView);
            mCardView = itemView.findViewById(R.id.carddviewuser);

        }

    }}
