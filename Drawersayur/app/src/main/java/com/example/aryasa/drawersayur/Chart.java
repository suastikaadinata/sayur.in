package com.example.aryasa.drawersayur;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Adpater.Checkout;
import com.example.aryasa.drawersayur.Model.Sayur;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Chart extends AppCompatActivity {

    private Button btPlacesAPI;
    private TextView tvPlaceAPI, txTotalharga,txOngkir,txTotal;
    private int PLACE_PICKER_REQUEST = 1;
    Button button_checkout;
    Intent intent;
    Button btndatepicker;
    Calendar cal,cal1;
    long maxDate;
    Date date;
    private int temp = 0;
    TextView txtdatepicker;
    private SimpleDateFormat dateFormatter;
    Spinner Spinnerjam;
    private String API_KERANJANG = Server.URL + "cart/list";
    private String API_TRANSAKSI = Server.URL + "transaksi";
    int id_user,totalharga,ongkir, totalbelanja;
    public final static String TAG_ID = "id";
    SharedPreferences sharedpreferences;
    public static final String my_shared_preferences = "my_shared_preferences";
    ArrayList<Sayur> listKeranjang = new ArrayList<Sayur>();;
    Context mContext;
    private RecyclerView mList;
    private LinearLayoutManager linearLayoutManager;
    private Checkout adapter;
    String tanggal_kirim, waktu, alamat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_layout);
        sharedpreferences = this.getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        id_user = sharedpreferences.getInt(TAG_ID, 0);
        adapter = new Checkout(this,listKeranjang);
        ambilkeranjang(API_KERANJANG,adapter);
        ongkir=3000;

        String[] number = new String[]{
                "06.00 WIB",
                "07.00 WIB",
                "08.00 WIB",
                "09.00 WIB",
                "10.00 WIB"
        };

        cal = Calendar.getInstance();
        cal1 = Calendar.getInstance();

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        btndatepicker = (Button) findViewById(R.id.buttondatepicker);
        button_checkout = (Button) findViewById(R.id.button_checkout);
        tvPlaceAPI = (TextView) findViewById(R.id.textView_alamat);
        txtdatepicker = (TextView) findViewById(R.id.textView_hari);
        btPlacesAPI = (Button) findViewById(R.id.buttonpick);
        txTotalharga = (TextView) findViewById(R.id.editText_harga_barang);
        txOngkir = (TextView) findViewById(R.id.editText_harga_pengiriman);
        txTotal = (TextView) findViewById(R.id.editText_total);
        txOngkir.setText("Rp. "+String.valueOf(ongkir));

        Spinnerjam = (Spinner) findViewById(R.id.spinner_jam);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,number );

        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        Spinnerjam.setAdapter(spinnerArrayAdapter);


        btPlacesAPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                try {
                    startActivityForResult(builder.build(Chart.this), PLACE_PICKER_REQUEST);
                } catch (GooglePlayServicesRepairableException e) {
                    e.printStackTrace();
                } catch (GooglePlayServicesNotAvailableException e) {
                    e.printStackTrace();
                }
            }
        });

        btndatepicker.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                DatePickerDialog dialog = new DatePickerDialog(Chart.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
                        // TODO Auto-generated method stub
                        Calendar newDate = Calendar.getInstance();
                        newDate.set( arg1,arg2,arg3 );
                        txtdatepicker.setText(dateFormatter.format(newDate.getTime()));
                        tanggal_kirim = dateFormatter.format(newDate.getTime());
                    }
                }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis()+24*60*60*1000);
                if(temp == 0) {
                    cal1.add(Calendar.DAY_OF_MONTH, 3);
                    temp = 1 ;
                }
                dialog.getDatePicker().setMaxDate(cal1.getTimeInMillis());
                dialog.show();
            }
        });


        button_checkout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                waktu = Spinnerjam.getSelectedItem().toString();
                postTransaksi(API_TRANSAKSI);
            }
        });

    }
    private void ambilkeranjang (String url, final Checkout keranjang){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String json = response.toString();
                Log.e("Response:", response.toString());
                listKeranjang.clear();
                try {
                    JSONArray jsonArray = new JSONArray(json);
                        for (int i = 0; i < jsonArray.length(); i++){
                            JSONObject jsonobject = jsonArray.getJSONObject(i);
                            listKeranjang.add(new Sayur(Server.URLIMAGE+ jsonobject.getString("foto"),jsonobject.getInt("sayur_id"),
                                    jsonobject.getString("nama"),jsonobject.getInt("harga"),jsonobject.getInt("jumlah_sayur")));
                            mList = (RecyclerView) findViewById(R.id.recyclerview_checkout);
                            LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                            mList.setLayoutManager(mLayoutManager);
                            mList.setAdapter(keranjang);
                            totalharga = totalharga+jsonobject.getInt("total_harga");
                    }
                    txTotalharga.setText("Rp. "+String.valueOf(totalharga));
                        txTotal.setText("Rp. "+String.valueOf(totalharga+ongkir));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("id", String.valueOf(id_user));
                return params;
            }
        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public void postTransaksi(String url){

        StringRequest stringRequest=new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String json = response.toString();
                try {
                    startActivity(new Intent(getApplicationContext(), Drawer.class));
                    Toast.makeText(getApplicationContext(),"Transaksi berhasil",Toast.LENGTH_LONG).show();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                if(error!=null && error.getMessage() !=null){
                    Toast.makeText(getApplicationContext(),"error VOLLEY "+error.getMessage(),Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();

                }
            }
        }){

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user_id", String.valueOf(id_user));
                params.put("alamat","alamat");
                params.put("waktu_pengiriman",tanggal_kirim+", "+waktu);
                for(int i = 0; i < listKeranjang.size(); i++) {
                    params.put("sayur_id["+i+"]",String.valueOf(listKeranjang.get(i).getId()));
                    params.put("jumlah["+i+"]",String.valueOf(listKeranjang.get(i).getJumlah()));
                }
                return params;
            }

        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format(
                        "%s "
                        , place.getAddress());
                tvPlaceAPI.setText(toastMsg);
                waktu=tvPlaceAPI.getText().toString();
            }
        }
    }
}
