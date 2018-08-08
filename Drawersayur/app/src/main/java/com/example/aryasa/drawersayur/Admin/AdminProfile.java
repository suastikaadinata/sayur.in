package com.example.aryasa.drawersayur.Admin;

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
import com.example.aryasa.drawersayur.Drawer;
import com.example.aryasa.drawersayur.Login;
import com.example.aryasa.drawersayur.Profile;
import com.example.aryasa.drawersayur.R;
import com.example.aryasa.drawersayur.ServerAPI.Server;
import com.example.aryasa.drawersayur.Singleton.Singleton;

import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdminProfile extends AppCompatActivity {
    TextView txt_email, txt_name, txt_nomor_telepon,txt_simpan;
    Button btn_logout,btn_editgambar;
    String name, email, nomor_telepon;
    SharedPreferences sharedpreferencesAdmnin;
    ImageView gambar_admin;
    int id;
    public static final String TAG_ID_ADMIN = "id";
    public static final String TAG_NAME_ADMIN = "name";
    public static final String TAG_EMAIL_ADMIN = "email";
    public static final String TAG_NOMOR_TELEPON_ADMIN = "nomor_telepon";
    private String API_URL_detailuser = Server.URL + "user/detail";
    private String API_URL = Server.URL + "user/edit";
    Bitmap bitmap, decoded;
    int PICK_IMAGE_REQUEST = 1;
    int bitmap_size = 60; // range 1 - 100

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);


        txt_simpan = (TextView) findViewById(R.id.textView_simpan);
        txt_name = (TextView) findViewById(R.id.editTextnamaprofileadmin);
        txt_email = (TextView) findViewById(R.id.editTextemailprofileadmin);
        txt_nomor_telepon = (TextView) findViewById(R.id.editTextNomorTeleponprofileadmin);
        btn_logout =(Button) findViewById(R.id.button_logoutprofileadmin);
        sharedpreferencesAdmnin = getSharedPreferences(Login.my_shared_preferences2, Context.MODE_PRIVATE);
        btn_editgambar =(Button) findViewById(R.id.button_ubah_gambar);
        gambar_admin =(ImageView) findViewById(R.id.imageView);

        id = sharedpreferencesAdmnin.getInt(TAG_ID_ADMIN, 0);
        name = sharedpreferencesAdmnin.getString(TAG_NAME_ADMIN, null);
        email = sharedpreferencesAdmnin.getString(TAG_EMAIL_ADMIN, null);
        nomor_telepon = sharedpreferencesAdmnin.getString(TAG_NOMOR_TELEPON_ADMIN, null);
        final Context context = this.getApplicationContext();
        gambar(String.valueOf(id) ,context);

        txt_name.setText(name);
        txt_email.setText(email);
        txt_nomor_telepon.setText(nomor_telepon);

        btn_logout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // update login session ke FALSE dan mengosongkan nilai id dan username
                SharedPreferences.Editor editor = sharedpreferencesAdmnin.edit();
                editor.putBoolean(Login.session_status2, false);
                editor.putInt(TAG_ID_ADMIN,0);
                editor.putString(TAG_NAME_ADMIN, null);
                editor.putString(TAG_EMAIL_ADMIN, null);
                editor.putString(TAG_NOMOR_TELEPON_ADMIN, null);
                editor.commit();
                Intent intent = new Intent(AdminProfile.this, Drawer.class);
                finish();
                startActivity(intent);
            }
        });
        btn_editgambar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });

        txt_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ubahprofile(context, String.valueOf(id));
            }
        });
    }

    private void gambar(final String ID, final Context context) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, API_URL_detailuser , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String json = response.toString();
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    showImage("http://10.0.2.2/img/"+jsonObject.getString("foto"));
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
                headers.put("Authorization", Server.TOKEN);
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
                gambar_admin.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
    }

    public void ubahprofile (final Context context, final String ID){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        // set title dialog
        alertDialogBuilder.setTitle("Yakin untuk Mengubah Profil?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk mengubah profile!")
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        StringRequest updateReq = new StringRequest(Request.Method.POST, API_URL,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        SharedPreferences.Editor editor = sharedpreferencesAdmnin.edit();
                                        editor.putString(TAG_NAME_ADMIN,txt_name.getText().toString() );
                                        editor.putString(TAG_EMAIL_ADMIN,txt_email.getText().toString() );
                                        editor.putString(TAG_NOMOR_TELEPON_ADMIN,txt_nomor_telepon.getText().toString() );
                                        editor.commit();
                                        Toast.makeText(getApplicationContext(), "Edit Profile Berhasil", Toast.LENGTH_SHORT).show();
                                        startActivity( new Intent(AdminProfile.this,AdminHome.class));
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(AdminProfile.this, "pesan : Gagal Edit Profil", Toast.LENGTH_SHORT).show();
                                    }
                                }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String,String> map = new HashMap<>();
                                map.put("id",ID);
                                map.put("name",txt_name.getText().toString());
                                map.put("email",txt_email.getText().toString());
                                map.put("nomor_telepon",txt_nomor_telepon.getText().toString());
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
        gambar_admin.setImageBitmap(decoded);
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




