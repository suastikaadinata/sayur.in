package com.example.aryasa.drawersayur;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Admin.AdminHome;
import com.example.aryasa.drawersayur.Admin.AdminProfile;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity{

    ProgressDialog pDialog;
    Button btn_register, btn_login;
    EditText txt_email, txt_password;
    Intent intent;


    ConnectivityManager conMgr;

    private String API_URL = Server.URL + "login";
//    int success;
//    private static final String TAG = Login.class.getSimpleName();
//    private static final String TAG_SUCCESS = "success";
//    private static final String TAG_MESSAGE = "message";
//    String tag_json_obj = "json_obj_req";
    public final static String TAG_ID = "id";
    public final static String TAG_NAME = "name";
    public final static String TAG_EMAIL = "email";
    public static final String TAG_NOMOR_TELEPON = "nomor_telepon";

    SharedPreferences sharedpreferences;
    SharedPreferences sharedpreferencesAdmnin;
    Boolean session = false;
    Boolean sessionAdmin = false;
    int id;
    String name;
    String email;
    String nomor_telepon;

    public static final String my_shared_preferences = "my_shared_preferences";
    public static final String my_shared_preferences2 = "my_shared_preferences2";
    public static final String session_status = "session_status";
    public static final String session_status2 = "session_status2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (conMgr.getActiveNetworkInfo() != null
                    && conMgr.getActiveNetworkInfo().isAvailable()
                    && conMgr.getActiveNetworkInfo().isConnected()) {
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        }

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register = (Button) findViewById(R.id.btn_register);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_password = (EditText) findViewById(R.id.txt_password);

       //   Cek session login USER jika TRUE maka langsung buka Profile
        sharedpreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedpreferences.getBoolean(session_status, false);
        id = sharedpreferences.getInt(TAG_ID, 0);
        name = sharedpreferences.getString(TAG_NAME, null);
        email = sharedpreferences.getString(TAG_EMAIL, null);
        nomor_telepon = sharedpreferences.getString(TAG_NOMOR_TELEPON, null);

        if (session) {
            Intent intent = new Intent(Login.this, Profile.class);
            intent.putExtra(TAG_ID,id);
            intent.putExtra(TAG_NAME, name);
            intent.putExtra(TAG_EMAIL, email);
            intent.putExtra(TAG_NOMOR_TELEPON, nomor_telepon);
            finish();
            startActivity(intent);
        }
          //Cek session login ADMin jika TRUE maka langsung buka Profile Admin
        sharedpreferencesAdmnin = getSharedPreferences(my_shared_preferences2, Context.MODE_PRIVATE);
        sessionAdmin = sharedpreferencesAdmnin.getBoolean(session_status2, false);
        name = sharedpreferencesAdmnin.getString(TAG_NAME, null);
        email = sharedpreferencesAdmnin.getString(TAG_EMAIL, null);
        nomor_telepon = sharedpreferencesAdmnin.getString(TAG_NOMOR_TELEPON, null);
        if (sessionAdmin) {
            Intent intent = new Intent(Login.this, AdminProfile.class);
            intent.putExtra(TAG_NAME, name);
            intent.putExtra(TAG_EMAIL, email);
            intent.putExtra(TAG_NOMOR_TELEPON, nomor_telepon);
            finish();
            startActivity(intent);
        }

        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
               String email = txt_email.getText().toString();
               String password = txt_password.getText().toString();

              //   mengecek kolom yang kosong
             if (email.trim().length() > 0 && password.trim().length() > 0) {
                 if (conMgr.getActiveNetworkInfo() != null
                         && conMgr.getActiveNetworkInfo().isAvailable()
                         && conMgr.getActiveNetworkInfo().isConnected()) {
                     checkLogin(email, password);
                 } else {
                     Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_LONG).show();

                 }
             }else {
                    // Prompt user to enter credentials
                    Toast.makeText(getApplicationContext() ,"Kolom tidak boleh kosong", Toast.LENGTH_LONG).show();
               }


            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                intent = new Intent(Login.this, Register.class);
                finish();
                startActivity(intent);
            }
        });

    }

    private void checkLogin(final String email, final String password) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Logging in ...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                hideDialog();
                String json = response.toString();
                try{
                    JSONObject jsonObject = new JSONObject(json);

                    if(jsonObject.getString("status").equals("failed")){
                        Toast.makeText(getApplicationContext(),"Email atau password salah", Toast.LENGTH_SHORT).show();
                    }else{
                        if(jsonObject.getString("tipe").equals("admin")) {
                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");
                            String tlp = jsonObject.getString("nomor_telepon");
                            SharedPreferences.Editor editor = sharedpreferencesAdmnin.edit();
                            editor.putBoolean(session_status2, true);
                            editor.putString(TAG_NAME,name );
                            editor.putString(TAG_EMAIL,email );
                            editor.putString(TAG_NOMOR_TELEPON,tlp );
                            editor.commit();
                            Intent intent = new Intent(getApplicationContext(), AdminHome.class);
//                            intent.putExtra(TAG_ID,id);
//                            intent.putExtra(TAG_NAME,name);
//                            intent.putExtra(TAG_EMAIL,email);
//                            intent.putExtra(TAG_NOMOR_TELEPON,tlp);
                            startActivity(intent);
                            finish();
                        }
                        if(jsonObject.getString("tipe").equals("user")) {
                            int id = jsonObject.getInt("id");
                            String name = jsonObject.getString("name");
                            String tlp = jsonObject.getString("nomor_telepon");
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putBoolean(session_status, true);
                            editor.putInt(TAG_ID,id);
                            editor.putString(TAG_NAME,name );
                            editor.putString(TAG_EMAIL,email );
                            editor.putString(TAG_NOMOR_TELEPON,tlp );
                            editor.commit();
                            Intent intent = new Intent(getApplicationContext(), Drawer.class);
//                            intent.putExtra(TAG_ID,id);
//                            intent.putExtra(TAG_NAME,name);
//                            intent.putExtra(TAG_EMAIL,email);
//                            intent.putExtra(TAG_NOMOR_TELEPON,tlp);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
                    catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
                error.printStackTrace();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);
                return params;
            }
        };

        Singleton.getInstance(this).addToRequestQueue(stringRequest);
    }
//
//                try {
//                    JSONObject jObj = new JSONObject(response);
//                    success = jObj.getInt(TAG_SUCCESS);
//
//                    // Check for error node in json
//                    if (success == 1) {
//                        String username = jObj.getString(TAG_USERNAME);
//                        String id = jObj.getString(TAG_ID);
//
//                        Log.e("Successfully Login!", jObj.toString());
//
//                        Toast.makeText(getApplicationContext(), jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
//
//                        // menyimpan login ke session
//                        SharedPreferences.Editor editor = sharedpreferences.edit();
//                        editor.putBoolean(session_status, true);
//                        editor.putString(TAG_ID, id);
//                        editor.putString(TAG_USERNAME, username);
//                        editor.commit();
//
//                        // Memanggil main activity
//                        Intent intent = new Intent(Login.this, Drawer.class);
//                        intent.putExtra(TAG_ID, id);
//                        intent.putExtra(TAG_USERNAME, username);
//                        finish();
//                        startActivity(intent);
//                    } else {
//                        Toast.makeText(getApplicationContext(),
//                                jObj.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
//
//                    }
//                } catch (JSONException e) {
//                    // JSON error
//                    e.printStackTrace();
//                }

//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, "Login Error: " + error.getMessage());
//                Toast.makeText(getApplicationContext(),
//                        error.getMessage(), Toast.LENGTH_LONG).show();
//
//                hideDialog();
//
//            }
//        }) {
//
//            @Override
//            protected Map<String, String> getParams() {
//                // Posting parameters to login url
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("username", username);
//                params.put("password", password);
//
//                return params;
//            }
//
//        };
//
//        // Adding request to request queue


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        intent = new Intent(Login.this, Drawer.class);
        finish();
        startActivity(intent);
    }

}
