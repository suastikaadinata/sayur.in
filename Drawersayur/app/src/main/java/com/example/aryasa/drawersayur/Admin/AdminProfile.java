package com.example.aryasa.drawersayur.Admin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aryasa.drawersayur.Drawer;
import com.example.aryasa.drawersayur.Login;
import com.example.aryasa.drawersayur.Profile;
import com.example.aryasa.drawersayur.R;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AdminProfile extends AppCompatActivity {
    TextView txt_email, txt_name, txt_nomor_telepon,txt_simpan;
    Button btn_logout,btn_editgambar;
    String name, email, nomor_telepon;
    SharedPreferences sharedpreferencesAdmnin;
    ImageView gamnbar_admin;
    int id;
    public static final String TAG_ID_ADMIN = "id";
    public static final String TAG_NAME_ADMIN = "name";
    public static final String TAG_EMAIL_ADMIN = "email";
    public static final String TAG_NOMOR_TELEPON_ADMIN = "nomor_telepon";

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
        gamnbar_admin =(ImageView) findViewById(R.id.imageView);

        id = sharedpreferencesAdmnin.getInt(TAG_ID_ADMIN, 0);
        name = sharedpreferencesAdmnin.getString(TAG_NAME_ADMIN, null);
        email = sharedpreferencesAdmnin.getString(TAG_EMAIL_ADMIN, null);
        nomor_telepon = sharedpreferencesAdmnin.getString(TAG_NOMOR_TELEPON_ADMIN, null);


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

            }
        });
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
        gamnbar_admin.setImageBitmap(decoded);
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




