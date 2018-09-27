package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.aryasa.drawersayur.Callbacks;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import java.util.ArrayList;

public class Checkout extends RecyclerView.Adapter<Checkout .MyViewHolder> {
    private int total=0, harga;
    private int jumlah=1;
    Callbacks callbacks;
    Context mContext;
    ArrayList<Sayur>keranjang;


    public Checkout (Context context, ArrayList<Sayur> keranjang, Callbacks callbacks){
        this.mContext = context;
        this.callbacks = callbacks;
        this.keranjang = keranjang;
    }
    public void addCartItems(int id, int jumlah){

        for(int i = 0; i < this.keranjang.size(); i++) {
            if(jumlah < 1){
                if (this.keranjang.get(i).getId() == id) {
                    this.keranjang.remove(i);
                    notifyItemRemoved(i);
                }
            }else{

                if (this.keranjang.get(i).getId() == id) {
                    this.keranjang.get(i).setJumlah(jumlah);
                }
            }
        }
        notifyDataSetChanged();
    }

    public void total(int harga){
        total = total+harga;
    }
    public void kurangtotal(int harga){
        total = total-harga;
    }


    public void harga(int harga){
        this.harga=harga;
    }
    public  int getHarga(){
        return this.harga;
    }

    @Override
    public Checkout .MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_list_row ,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        jumlah = Integer.parseInt(holder.itemKuan.getText().toString());
        ImageLoader imageLoader = Singleton.getInstance(mContext).getImageLoader();
        holder.itemTitle.setText(keranjang.get(position).getNama());
        holder.itemKuan.setText(String.valueOf(keranjang.get(position).getJumlah()));
        holder.itemPrice.setText(String.valueOf(keranjang.get(position).getHarga()));
        imageLoader.get(keranjang.get(position).getFoto(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                holder.imageView.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        holder.btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlah = Integer.parseInt(holder.itemKuan.getText().toString());
                if(jumlah<=1){
                    jumlah=0;
                    kurangtotal(keranjang.get(position).getHarga());
                    callbacks.updateharga(keranjang.get(position).getHarga(),1);
                    callbacks.updateCart(keranjang.get(position),2,jumlah);
                }else {
                    kurangtotal(keranjang.get(position).getHarga());
                    callbacks.updateharga(keranjang.get(position).getHarga(),1);
                    holder.itemKuan.setText(String.valueOf(--jumlah));
                    callbacks.updateCart(keranjang.get(position),2,jumlah);
                }

            }
        });
        holder.btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlah = Integer.parseInt(holder.itemKuan.getText().toString());
                callbacks.updateharga(keranjang.get(position).getHarga(),0);
                holder.itemKuan.setText(String.valueOf(jumlah+1));
                callbacks.updateCart(keranjang.get(position),2,jumlah+1);
            }
        });
        holder.btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                keranjang.remove(position);
                notifyItemRemoved(position);
                callbacks.updateharga(0,2);
            }
        });

    }


    @Override
    public int getItemCount() {
        return keranjang.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTitle,itemPrice, itemKuan;
        ImageView imageView;
        Button btn_minus;
        Button btn_plus , btn_del;
        TextView tvjumlah;
        public MyViewHolder(View itemView) {
            super(itemView);
            btn_minus = (Button) itemView.findViewById(R.id.buttonMinus);
            btn_plus = (Button) itemView.findViewById(R.id.buttonPlus);
            btn_del = (Button) itemView.findViewById(R.id.button_delete);
            itemTitle = (TextView)itemView.findViewById(R.id.cart_namaSayur);
            itemKuan = (TextView) itemView.findViewById(R.id.textView_jumlahSayur);
            itemPrice = (TextView) itemView.findViewById(R.id.cart_hargaSayur);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

}