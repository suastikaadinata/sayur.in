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

import com.example.aryasa.drawersayur.Admin.Admindetailtransaksi;
import com.example.aryasa.drawersayur.Admin.Adminubahsayur;
import com.example.aryasa.drawersayur.Admin.Adminviewuser;
import com.example.aryasa.drawersayur.Model.AdminInprogress;
import com.example.aryasa.drawersayur.Model.UserCompleted;
import com.example.aryasa.drawersayur.Model.UserInprogress;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Model.Userdata;

import java.util.List;

public class AdminInprogressAdapter extends RecyclerView.Adapter<AdminInprogressAdapter.AdminInprogressViewHolder> {
    private Context mContext;
    private List<AdminInprogress> mAdminInprogress;

    public AdminInprogressAdapter(Context mContext, List<AdminInprogress> mAdminInprogressList) {
        this.mContext = mContext;
        this.mAdminInprogress= mAdminInprogressList;
    }

    @Override
    public AdminInprogressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_admin_history_inprogress, parent, false);
        return new AdminInprogressViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final AdminInprogressViewHolder holder, int position) {
        holder.mBarang1.setText(mAdminInprogress.get(position).getTextView_barang1());
        holder.mBarang2.setText(mAdminInprogress.get(position).getTextView_barang2());
        holder.mBarang3.setText(mAdminInprogress.get(position).getTextView_barang3());
        holder.mTanggal.setText(mAdminInprogress.get(position).getTextView_tanggal());
        holder.mJam.setText(mAdminInprogress.get(position).getTextView_jam());
        holder.mGambar.setImageResource(mAdminInprogress.get(position).getImageView());
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, Admindetailtransaksi.class);
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

