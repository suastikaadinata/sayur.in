package com.example.aryasa.drawersayur.Adpater;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private int counter = 1;
    private int jumlah1=1;
    private Context mContext;

    private CoordinatorLayout coordinatorLayout;
    private TextView cart;

    private ArrayList<Sayur> cartList;
    public CartAdapter(Context context, ArrayList<Sayur> mSayurlist){
        this.mContext = context;
        this.cartList = mSayurlist;
    }

    public void addCartItems(int id, int jumlah){
        for(int i = 0; i < this.cartList.size(); i++) {
            if(jumlah > 0){
                if (this.cartList.get(i).getId() == id) {
                    this.cartList.get(i).setJumlah(jumlah);
                }
            }else{
                if (this.cartList.get(i).getId() == id) {
                    this.cartList.remove(i);
                }
            }
        }
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
//        ImageLoader imageLoader = Singleton.getInstance(mContext).getImageLoader();
//        imageLoader.get(cartList.get(position).getFoto(), new ImageLoader.ImageListener() {
//            @Override
//            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
//                holder.imageView.setImageBitmap(response.getBitmap());
//            }
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });

            holder.itemTitle.setText(cartList.get(position).getNama());
            holder.itemPrice.setText("Rp "+cartList.get(position).getHarga());
            holder.tvjumlah.setText(String.valueOf(cartList.get(position).getJumlah()));
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
        //ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemTitle = (TextView)itemView.findViewById(R.id.itemTitle);
            itemPrice = (TextView)itemView.findViewById(R.id.itemPrice);
            itemKuan = (TextView)itemView.findViewById(R.id.cart_kuantitas);
            tvjumlah = (TextView) itemView.findViewById(R.id.textView_jumlahSayur);
            //imageView = (ImageView) itemView.findViewById(R.id.imageView_bottomsheet);
        }
    }

}