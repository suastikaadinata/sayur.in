package com.example.aryasa.drawersayur.ServerAPI;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.aryasa.drawersayur.Login;

public class Server{
    //untuk emu genymotion menggunakan ip = http://10.0.3.2/
    //untuk emu avd android menggunakan ip = http://10.0.2.2/
    //untuk langsung coba dihandphone menggunakan jaringan yang sama dan liat ipnya contoh http://192.168.1.14/
    public static final String URL = "http://10.0.2.2:81/api/";
    public static final String URLIMAGE = "http://10.0.2.2:81/img/";
        //SharedPreferences sharedpreferences = getSharedPreferences(Login.my_shared_preferences2, Context.MODE_PRIVATE);
        //token = "Bearer "+ sharedpreferences.getString(Login.TAG_TOKEN, null);
}
