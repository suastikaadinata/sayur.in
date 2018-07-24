package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private ArrayList<Sayur> sayurList;
    private SayurAdapter.Callbacks callbacks;
    private int counter = 1;

    private ArrayList<Sayur> cartList;
    public CartAdapter(Context context, ArrayList<Sayur> cartList){
        this.cartList = cartList;
    }

public void addCartItems(ArrayList<Sayur> cartList){
        this.cartList = cartList;
        notifyDataSetChanged();
        }

@Override
public CartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottomsheet_row ,parent,false);

        return new MyViewHolder(view);
        }

@Override
public void onBindViewHolder(final CartAdapter.MyViewHolder holder, int position) {
        holder.itemTitle.setText(cartList.get(position).getNama());
        holder.itemPrice.setText("Rp "+cartList.get(position).getHarga());
        holder.btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               counter++;
               holder.tvjumlah.setText(String.valueOf(counter));
            }
        });
    holder.btn_minus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            counter--;
            holder.tvjumlah.setText(String.valueOf(counter));
        }
    });
        }

@Override
public int getItemCount() {
        return cartList.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView itemTitle,itemPrice;
    Button btn_minus;
    Button btn_plus;
    TextView tvjumlah;
    public MyViewHolder(View itemView) {
        super(itemView);
        itemTitle = (TextView)itemView.findViewById(R.id.itemTitle);
        itemPrice = (TextView)itemView.findViewById(R.id.itemPrice);
        btn_minus = (Button)itemView.findViewById(R.id.buttonMinus);
        btn_plus = (Button)itemView.findViewById(R.id.buttonPlus);
        tvjumlah = (TextView) itemView.findViewById(R.id.textView_jumlahSayur);

    }
}
}