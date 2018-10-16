package com.example.aryasa.drawersayur.Admin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.example.aryasa.drawersayur.Login;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Adminubahsayur extends AppCompatActivity {

    ImageView gambar_sayur;
    TextView txt_nama;
    TextView txt_harga;
    Button btn_edit;
    Bitmap bitmap, decoded;
    private String API_URL = Server.URL + "sayur/delete";
    private String API_URL_detailsayur = Server.URL + "sayur/detail";
    private String API_URL_ubahsayur = Server.URL + "sayur/edit";
    int PICK_IMAGE_REQUEST = 1;
    int bitmap_size = 60; // range 1 - 100
    Button btn_delete;
    ProgressDialog pd;
    Button btn_ubah;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminubahsayur);

        btn_ubah = (Button) findViewById(R.id.button_ubah);
        txt_nama = findViewById(R.id.txt_namasayur);
        txt_harga = findViewById(R.id.txt_hargasayur);
        btn_edit = (Button) findViewById(R.id.btn_ubahgambarsayuredit);
        gambar_sayur = (ImageView) findViewById(R.id.gambar_sayur_edit);
        btn_delete = (Button)findViewById(R.id.button_delete);
        final Context context = this.getApplicationContext();
        final Bundle mBundle = getIntent().getExtras();
        pd = new ProgressDialog(Adminubahsayur.this);
        SharedPreferences sharedpreferencesAdmnin = getSharedPreferences(Login.my_shared_preferences2, Context.MODE_PRIVATE);
        token = "Bearer "+sharedpreferencesAdmnin.getString("token", null);

        if (mBundle != null) {
            txt_nama.setText(mBundle.getString("nama"));
            gambar_sayur.setImageResource(mBundle.getInt("gambar"));
            txt_harga.setText(mBundle.getString("harga"));
        }
        detailsayur(String.valueOf(mBundle.getInt("id")) ,context);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showFileChooser();
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletesayur(String.valueOf(mBundle.getInt("id")), context);
            }
        });

        btn_ubah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ubahsayur(String.valueOf(mBundle.getInt("id")), context);
            }
        });
    }

    public void ubahsayur (final String ID,final Context context){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title dialog
        alertDialogBuilder.setTitle("Yakin untuk Mengubah data sayur?" );

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk mengubah data sayur!")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        StringRequest updateReq = new StringRequest(Request.Method.POST, API_URL_ubahsayur,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {

                                        Toast.makeText(getApplicationContext(), "Edit Sayur Berhasil", Toast.LENGTH_SHORT).show();
                                        startActivity( new Intent(Adminubahsayur.this,AdminHome.class));
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(Adminubahsayur.this, "pesan : Gagal Edit sayur", Toast.LENGTH_SHORT).show();
                                    }
                                }){
                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                HashMap<String, String> headers = new HashMap<>();
                                headers.put("Accept", "application/json");
                                headers.put("Authorization", token);
                                return headers;
                            }
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> map = new HashMap<>();
                                map.put("id",ID);
                                map.put("nama",txt_nama.getText().toString());
                                map.put("harga",txt_harga.getText().toString());
                                map.put("foto", getStringImage(decoded));

                                return map;
                            }
                        };

                        Singleton.getInstance(context).addToRequestQueue(updateReq);

                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }


    private void detailsayur(final String ID, final Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL_detailsayur , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String json = response.toString();
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    txt_nama.setText(jsonObject.getString("nama"));
                    txt_harga.setText(jsonObject.getString("harga"));
                    showImage(Server.URLIMAGE+jsonObject.getString("foto"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(context,"Error Bro",Toast.LENGTH_LONG ).show();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Accept", "application/json");
                headers.put("Authorization", token);
                return headers;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("id", ID);
                return params;
            }
        };

        Singleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    public void showImage(String linkImage){
        ImageLoader imageLoader = Singleton.getInstance(this.getApplicationContext()).getImageLoader();
        imageLoader.get(linkImage, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
                gambar_sayur.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

    private void deletesayur(final String ID, final Context context){
        pd.setMessage("Menghapus Sayur");
        pd.setCancelable(false);
        pd.show();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title dialog
        alertDialogBuilder.setTitle("Hapus Sayur yang dipilih?" );

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk hapus!")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL , new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                pd.cancel();
                                Toast.makeText(getApplicationContext(), "Berhasil Hapus",
                                        Toast.LENGTH_SHORT).show();
                                Intent mIntent = new Intent(Adminubahsayur.this, AdminHome.class);
                                startActivity(mIntent);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                pd.cancel();
                                error.printStackTrace();
                            }
                        }){
                            @Override
                            public Map<String, String> getHeaders() throws AuthFailureError {
                                HashMap<String, String> headers = new HashMap<>();
                                headers.put("Accept", "application/json");
                                headers.put("Authorization", token);
                                return headers;
                            }

                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                HashMap<String, String> params = new HashMap<>();
                                params.put("id", ID);
                                return params;
                            }
                        };

                        Singleton.getInstance(context).addToRequestQueue(stringRequest);
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }


    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri filePath = data.getData();
            try {

                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                // 512 adalah resolusi tertinggi setelah image di resize, bisa di ganti.
                setToImageView(getResizedBitmap(bitmap, 512));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void setToImageView(Bitmap bmp) {
        //compress image
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, bitmap_size, bytes);
        decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));

        //menampilkan gambar yang dipilih dari camera/gallery ke ImageView
        gambar_sayur.setImageBitmap(decoded);
    }
    // fungsi resize image
    public Bitmap getResizedBitmap(Bitmap image, int maxSize) {
        int width = image.getWidth();
        int height = image.getHeight();

        float bitmapRatio = (float) width / (float) height;
        if (bitmapRatio > 1) {
            width = maxSize;
            height = (int) (width / bitmapRatio);
        } else {
            height = maxSize;
            width = (int) (height * bitmapRatio);
        }
        return Bitmap.createScaledBitmap(image, width, height, true);
    }


}
