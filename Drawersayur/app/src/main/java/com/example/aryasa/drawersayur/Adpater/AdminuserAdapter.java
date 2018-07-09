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
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Model.Userdata;

import java.util.List;

public class AdminuserAdapter extends RecyclerView.Adapter<AdminuserAdapter.UserViewHolder> {
    private Context mContext;
    private List<Userdata> mUserList;

    public AdminuserAdapter(Context mContext, List<Userdata> mUserListList) {
        this.mContext = mContext;
        this.mUserList = mUserListList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem_row_adminuser, parent, false);
        return new UserViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position) {
        holder.mNama.setText(mUserList.get(position).getTxt_username());
        holder.mEmail.setText(mUserList.get(position).getTxt_email());
        holder.mNotelp.setText(mUserList.get(position).getTxt_notelp());
        holder.mGambar.setImageResource(mUserList.get(position).getGambaruser());
        holder.btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, Adminviewuser.class);
                mIntent.putExtra("nama", mUserList.get(holder.getAdapterPosition()).getTxt_username());
                mIntent.putExtra("email", mUserList.get(holder.getAdapterPosition()).getTxt_email());
                mIntent.putExtra("notelp", mUserList.get(holder.getAdapterPosition()).getTxt_notelp());
                mIntent.putExtra("gambar", mUserList.get(holder.getAdapterPosition()).getGambaruser());
                mContext.startActivity(mIntent);
            }
        });

    }
    @Override
    public int getItemCount() {

        return mUserList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {


        TextView mNama;
        TextView mEmail;
        TextView mNotelp;
        ImageView mGambar;
        CardView mCardView;
        Button btn_lihat;

        UserViewHolder(View itemView) {
            super(itemView);

            mGambar = itemView.findViewById(R.id.gambaruser);
            mNama= itemView.findViewById(R.id.txt_username);
            mEmail = itemView.findViewById(R.id.txt_email);
            mNotelp = itemView.findViewById(R.id.txt_notelp);
            mCardView = itemView.findViewById(R.id.carddviewuser);
            btn_lihat = itemView.findViewById(R.id.btn_lihat_sayur);
        }

    }}
