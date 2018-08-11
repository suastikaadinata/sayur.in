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
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Adpater.Callbacks;
import com.example.aryasa.drawersayur.Adpater.CartAdapter;
import com.example.aryasa.drawersayur.Adpater.SayurAdapter;
import com.example.aryasa.drawersayur.Chart;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.Model.SayurListModel;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BottomSheetDialogFragment implements Callbacks {
    Context mContext;
    int position,harga,total,jumlahsay=1;
    BottomSheetDialog dialog;
    private String API_URL = Server.URL + "sayur/dijual";
    private String API_URL_Search = Server.URL + "sayur/search";
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
    final Context context = this.getContext();
    private SayurAdapter sayurAdapter;


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
        sayurAdapter = new SayurAdapter(mContext, listSayur, this);
        getSayurApi(API_URL, view);

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
    public void getSayurApi(String url, final View view){
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                listSayur.clear();
                sayurAdapter.notifyDataSetChanged();
                try{
                    for (int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        listSayur.add(new Sayur(Server.URLIMAGE+ jsonObject.getString("foto") ,jsonObject.getInt("id"),jsonObject.getString("nama"), jsonObject.getInt("harga")));
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview1);
                        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                        recyclerView.setLayoutManager(gridLayoutManager);
                        recyclerView.setAdapter(sayurAdapter);
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
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        super.onCreateOptionsMenu(menu,inflater);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                cariSayur(newText,context);
                return false;
            }
        });
    }

    private void cariSayur(final String keyword, final Context context ) {

        StringRequest SearchReq = new StringRequest(Request.Method.POST, API_URL_Search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response){
                        String json = response.toString();
                        Log.e("Response: ", response.toString());
                        try {
                            JSONObject jsonObject = new JSONObject(json);
                            JSONArray jsonArray = jsonObject.getJSONArray("data");
                            listSayur.clear();
                            sayurAdapter.notifyDataSetChanged();

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject jsonObjectArray = jsonArray.getJSONObject(i);
                                listSayur.add(new Sayur(Server.URLIMAGE+ jsonObjectArray.getString("foto") ,jsonObjectArray.getInt("id"),jsonObjectArray.getString("nama"), jsonObjectArray.getInt("harga")));
                                sayurAdapter.notifyDataSetChanged();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("keyword",keyword);
                return map;
            }
        };

        Singleton.getInstance(context).addToRequestQueue(SearchReq);

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
