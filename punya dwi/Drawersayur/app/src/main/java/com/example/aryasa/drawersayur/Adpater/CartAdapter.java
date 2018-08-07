package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
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
    private int counter = 1;
    private int jumlah1=1;

    private CoordinatorLayout coordinatorLayout;
    private TextView cart;

    private ArrayList<Sayur> cartList;
    public CartAdapter(Context context, ArrayList<Sayur> cartList){
        this.cartList = cartList;
    }

    public void addCartItems(ArrayList<Sayur> cartList){
        this.cartList = cartList;
        notifyDataSetChanged();
        }
    public void removeAt(int position) {
        cartList.remove(position);
        notifyItemRemoved(position);
    }
    public  void isiJumlah(int jumlah){
        this.jumlah1=jumlah;

    }



@Override
public CartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottomsheet_row ,parent,false);

        return new MyViewHolder(view);
        }

@Override
public void onBindViewHolder(final CartAdapter.MyViewHolder holder, final int position) {
        holder.itemTitle.setText(cartList.get(position).getNama());
        holder.itemPrice.setText("Rp "+cartList.get(position).getHarga());
        holder.tvjumlah.setText(String.valueOf(jumlah1));
        }


@Override
public int getItemCount() {
        return cartList.size();
        }

    public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView itemTitle,itemPrice, itemKuan;
    Button btn_minus;
    Button btn_plus , btn_del;
    TextView tvjumlah;
    public MyViewHolder(View itemView) {
        super(itemView);
        itemTitle = (TextView)itemView.findViewById(R.id.itemTitle);
        itemPrice = (TextView)itemView.findViewById(R.id.itemPrice);
        itemKuan = (TextView)itemView.findViewById(R.id.cart_kuantitas);
        tvjumlah = (TextView) itemView.findViewById(R.id.textView_jumlahSayur);
    }
}

}