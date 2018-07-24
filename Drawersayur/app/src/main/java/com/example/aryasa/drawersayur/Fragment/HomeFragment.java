package com.example.aryasa.drawersayur.Fragment;


import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
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
import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BottomSheetDialogFragment implements SayurAdapter.Callbacks {
    Context mContext;
    BottomSheetDialog dialog;
    private String API_URL = Server.URL + "sayur/dijual";
    ArrayList<Sayur> listSayur = new ArrayList<Sayur>();
    private ArrayList<Sayur> cartList;
    private RecyclerView bottomSheetRecyclerview;
    private CoordinatorLayout coordinatorLayout;
    private BottomSheetBehavior behavior;
    private View persistentbottomSheet;
    private TextView cart;
    private CartAdapter CartAdapter;
    private SayurAdapter.Callbacks callbacks;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        final View view = inflater.inflate(R.layout.fragment_home2, container, false);
        mContext = view.getContext();
        final SayurAdapter sayurAdapter = new SayurAdapter(mContext, listSayur, this);
        getSayurApi(API_URL, view, sayurAdapter);

        //bottomsheet
        cartList = new ArrayList<>();
        coordinatorLayout = (CoordinatorLayout)view.findViewById(R.id.coordinator);
        persistentbottomSheet = coordinatorLayout.findViewById(R.id.bottomsheet_sayur);
        bottomSheetRecyclerview = coordinatorLayout.findViewById(R.id.recyclerview_bottom_sheet);
        cart = (TextView) coordinatorLayout.findViewById(R.id.jumlah_cart);
        bottomSheetRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        CartAdapter = new CartAdapter(mContext,cartList);
        bottomSheetRecyclerview.setAdapter(CartAdapter);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(persistentbottomSheet);

        return view;
    }




    public void getSayurApi(String url, final View view, final SayurAdapter sayur){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try{
                    for (int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        listSayur.add(new Sayur("http://192.168.42.41/img/"+jsonObject.getString("foto") ,jsonObject.getString("nama"), jsonObject.getInt("harga")));
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
//    public void init_modal_bottomsheet() {
//        View modalbottomsheet = getLayoutInflater().inflate(R.layout.bottomsheet_layout, null);
//
//        dialog = new BottomSheetDialog(mContext);
//        dialog.setContentView(modalbottomsheet);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.setCancelable(false);
//    }

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
    public void updateCart(Sayur cartlist) {
        cartList.add(cartlist);
        cart.setText(String.valueOf(cartList.size()));
        CartAdapter.addCartItems((ArrayList<Sayur>) cartList);
    }


}
