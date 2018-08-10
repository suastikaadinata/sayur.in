package com.example.aryasa.drawersayur.Fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.aryasa.drawersayur.Adpater.Callbacks;
import com.example.aryasa.drawersayur.Adpater.CartAdapter;
import com.example.aryasa.drawersayur.Adpater.SayurAdapter;
import com.example.aryasa.drawersayur.Chart;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BottomSheetDialogFragment implements Callbacks {
    Context mContext;
    int position,harga,total,jumlahsay=1;
    BottomSheetDialog dialog;
    private String API_URL = Server.URL + "sayur/dijual";
    ArrayList<Sayur> listSayur = new ArrayList<Sayur>();
    ArrayList<Sayur> cartList;
    ArrayList<Integer> keranjang;
    ArrayList<Integer> jumlasayur;
    private RecyclerView bottomSheetRecyclerview, recyclerview;
    private CoordinatorLayout coordinatorLayout;
    private BottomSheetBehavior behavior;
    private View persistentbottomSheet;
    private TextView cart,totalHarga, opencart;
    private com.example.aryasa.drawersayur.Adpater.CartAdapter CartAdapter;
    private Callbacks callbacks;
    private FrameLayout frameLayout;
    SharedPreferences shared;
    SharedPreferences prefcart;
    int id;
    public static final String MyPREFERENCES = "myprefs";

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        final View view = inflater.inflate(R.layout.fragment_home2, container, false);
        mContext = view.getContext();
        SharedPreferences prefCart = mContext.getSharedPreferences("cart",mContext.MODE_PRIVATE);
        final SayurAdapter sayurAdapter = new SayurAdapter(mContext, listSayur, this);
        getSayurApi(API_URL, view, sayurAdapter);

        //bottomsheet
        keranjang = new ArrayList<>();
        jumlasayur = new ArrayList<>();
        cartList = new ArrayList<>();
        coordinatorLayout = (CoordinatorLayout)view.findViewById(R.id.coordinator);
        persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottomsheet_sayur);
        frameLayout = coordinatorLayout.findViewById(R.id.framehome);
        bottomSheetRecyclerview = coordinatorLayout.findViewById(R.id.recyclerview_bottom_sheet);
        bottomSheetRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        CartAdapter = new CartAdapter(mContext,cartList);
        bottomSheetRecyclerview.setAdapter(CartAdapter);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(persistentbottomSheet);

        persistentbottomSheet.setVisibility(View.INVISIBLE);


        cart = (TextView) coordinatorLayout.findViewById(R.id.jumlah_cart);
        totalHarga=(TextView) coordinatorLayout.findViewById(R.id.Jumlah_total);
        opencart= (TextView)coordinatorLayout.findViewById(R.id.pay);


        //open cart
        opencart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Chart.class);
                intent.putExtra("cc","200");
                intent.putExtra("harga",totalHarga.getText().toString());
                intent.putExtra("idsayur",keranjang);
                intent.putExtra("jumlah",jumlasayur);
                startActivity(intent);
            }
        });

        return view;
    }
    public void addkeranjang(int id){
        keranjang.add(id);
    }
    public void getSayurApi(String url, final View view, final SayurAdapter sayur){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                    for (int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        listSayur.add(new Sayur(Server.URLIMAGE+ jsonObject.getString("foto") ,jsonObject.getInt("id"),jsonObject.getString("nama"), jsonObject.getInt("harga")));
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(sayur);
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        Singleton.getInstance(this.getContext()).addToRequestQueue(jsonArrayRequest);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.drawer, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search){
            return true;
        }
        if (id == R.id.cart) {
            Intent cart = new Intent(getActivity(), Chart.class);
            startActivity(cart);
        }
        return super.onOptionsItemSelected(item);
    }

    public void setMargin(){
        if (behavior.getState()==BottomSheetBehavior.STATE_COLLAPSED){
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.setMargins(0,0,0,70);
            frameLayout.setLayoutParams(layoutParams);
        }
    }

    @Override
    public void updateCart(Sayur sayur, int jumlah, int status) {
        //1 -> pertama kali di tambahkan
        //2 -> sudah pernah ditambahkan
        if(status == 1){
            cartList.add(sayur);
        }
        persistentbottomSheet.setVisibility(View.VISIBLE);
        cart.setText(String.valueOf(cartList.size()));
        CartAdapter.addCartItems(sayur.getId(), jumlah);
        addkeranjang(sayur.getId());
    }

    @Override
    public void hapuscart(int Position) {
        CartAdapter.removeAt(position);
        if (cartList.size()==0){
            persistentbottomSheet.setVisibility(View.INVISIBLE);
        }
        cart.setText(String.valueOf(cartList.size()));
    }

    @Override
    public void updateJumlah(int jumlah) {
        jumlasayur.add(jumlah);
    }


    @Override
    public void updateharga(int harga) {
        totalHarga.setText(String.valueOf(harga));
    }



}
