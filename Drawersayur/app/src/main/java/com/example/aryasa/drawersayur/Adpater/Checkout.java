package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aryasa.drawersayur.R;

import java.util.ArrayList;

public class Checkout extends RecyclerView.Adapter<Checkout.MyViewHolder> {
    private int counter = 1;
    private int jumlah1=1;

    private CoordinatorLayout coordinatorLayout;
    private TextView cart;
    ArrayList<Integer>Cart;
    ArrayList<Integer>jumlah;
    public  void isiJumlah(int jumlah){
        this.jumlah1=jumlah;
    }

    public Checkout (Context context, ArrayList<Integer> Cart){
        this.Cart = Cart;
    }

    @Override
    public Checkout.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_row ,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemTitle.setText(String.valueOf(Cart.get(position)));
        holder.itemKuan.setText(String.valueOf(Cart.get(position)));
    }


    @Override
    public int getItemCount() {
        return Cart.size()+jumlah.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle,itemPrice, itemKuan;
        Button btn_minus;
        Button btn_plus , btn_del;
        TextView tvjumlah;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemTitle = (TextView)itemView.findViewById(R.id.cart_namaSayur);
            itemKuan = (TextView) itemView.findViewById(R.id.textView_jumlahSayur);
        }
    }

}