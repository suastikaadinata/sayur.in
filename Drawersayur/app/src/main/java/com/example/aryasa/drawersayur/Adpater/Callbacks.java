package com.example.aryasa.drawersayur.Adpater;

import com.example.aryasa.drawersayur.Model.Sayur;

public interface Callbacks {

    void updateCart(Sayur sayur, int status, int jumlah);
    void hapuscart (int Position);
    void updateJumlah (int i,int jumlah);
    void updateharga (int harga);
}