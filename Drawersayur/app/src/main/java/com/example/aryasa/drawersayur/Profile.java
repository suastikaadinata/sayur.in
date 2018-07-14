package com.example.aryasa.drawersayur;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Profile extends AppCompatActivity {

    TextView txt_email, txt_name, txt_nomor_telepon;
    Button btn_logout;
    String name, email, tlp;
    SharedPreferences sharedpreferences;
    Button btn_edit_user;
    ImageView gambar_user;

    public static final String TAG_NAME = "name";
    public static final String TAG_EMAIL = "email";
    public static final String TAG_NOMOR_TELEPON = "nomor_telepon";

    Bitmap bitmap, decoded;
    int PICK_IMAGE_REQUEST = 1;
    int bitmap_size = 60;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.edit_profil);

            txt_name = (TextView) findViewById(R.id.editTextnama);
            txt_email = (TextView) findViewById(R.id.editTextemail);
            txt_nomor_telepon = (TextView) findViewById(R.id.editTextNomorTelepon);
            btn_logout =(Button) findViewById(R.id.button_logout);
            sharedpreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);
            btn_edit_user =(Button) findViewById(R.id.button);
            gambar_user = (ImageView) findViewById(R.id.imageView);

            name = getIntent().getStringExtra(TAG_NAME);
            email = getIntent().getStringExtra(TAG_EMAIL);
            tlp = getIntent().getStringExtra(TAG_NOMOR_TELEPON);

            txt_name.setText(name);
            txt_email.setText(email);
            txt_nomor_telepon.setText(tlp);

            btn_logout.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    // update login session ke FALSE dan mengosongkan nilai id dan username
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putBoolean(Login.session_status, false);
                    editor.putString(TAG_NAME, null);
                    editor.putString(TAG_EMAIL, null);
                    editor.putString(TAG_NOMOR_TELEPON, null);
                    editor.commit();

                    Intent intent = new Intent(Profile.this, Drawer.class);
                    finish();
                    startActivity(intent);
                }
            });

            btn_edit_user.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    showFileChooser();
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
        gambar_user.setImageBitmap(decoded);
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
