package com.example.aryasa.drawersayur;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Controller.AppController;
import com.example.aryasa.drawersayur.ServerAPI.Server;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    ProgressDialog pDialog;
    Button btn_register, btn_login;
    EditText txt_username, txt_email, txt_notelp, txt_password, txt_confirm_password;
    Intent intent;

    ConnectivityManager conMgr;

    private String API_URL = Server.URL + "register";
    private static final String TAG = Register.class.getSimpleName();

//    private static final String TAG_SUCCESS = "success";
//    private static final String TAG_MESSAGE = "message";
//    int success;

    String tag_json_obj = "json_obj_req";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

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


        btn_register = (Button) findViewById(R.id.btn_register);
        txt_username = (EditText) findViewById(R.id.txt_username);
        txt_notelp = (EditText) findViewById(R.id.txt_notelp);
        txt_email = (EditText) findViewById(R.id.txt_email);
        txt_password = (EditText) findViewById(R.id.txt_password);
        txt_confirm_password = (EditText) findViewById(R.id.txt_confirm_password);


        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String username = txt_username.getText().toString();
                String notelp = txt_notelp.getText().toString();
                String email = txt_email.getText().toString();
                String password = txt_password.getText().toString();
                String confirm_password = txt_confirm_password.getText().toString();

                if (conMgr.getActiveNetworkInfo() != null
                        && conMgr.getActiveNetworkInfo().isAvailable()
                        && conMgr.getActiveNetworkInfo().isConnected()) {
                    checkRegister(username, notelp, email, password, confirm_password);
                } else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void checkRegister(final String username, final String notelp, final String email, final String password, final String confirm_password) {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setMessage("Register ...");
        showDialog();

        StringRequest strReq = new StringRequest(Request.Method.POST, API_URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                String json = response.toString();
                try{
                    JSONObject jsonObject = new JSONObject(json);
                    if(jsonObject.getString("status").equals("failed")){
                        hideDialog();
                        if(jsonObject.getString("field").equals("email")){
                            Toast.makeText(getApplicationContext(), "Email yang dimasukkan tidak sesuai format atau telah digunakan oleh user yang lain (contoh: abc@abc.com)",
                                    Toast.LENGTH_SHORT).show();
                        }else if(jsonObject.getString("field").equals("password")){
                            Toast.makeText(getApplicationContext(), "Konfirmasi password tidak sesuai dengan password yang telah dimasukkan sebelumnya",
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Email yang dimasukkan tidak sesuai format atau telah digunakan oleh user yang lain (contoh: abc@abc.com)",
                                    Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Konfirmasi password tidak sesuai dengan password yang telah dimasukkan sebelumnya",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        hideDialog();
                        startActivity(new Intent(getApplicationContext(), Drawer.class));
                        finish();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                Log.e(TAG, "Register Response: " + response.toString());
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Register Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", username);
                params.put("email", email);
                params.put("nomor_telepon", notelp);
                params.put("password", password);
                params.put("password_confirmation", confirm_password);
                params.put("tipe", "user");

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_json_obj);
    }

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
        intent = new Intent(Register.this, Login.class);
        finish();
        startActivity(intent);
    }
}