package com.example.aryasa.drawersayur.Adpater;

import com.example.aryasa.drawersayur.Model.Sayur;

public interface Callbacks {

    void updateCart(Sayur sayur, int jumlah, int status);
    void hapuscart(int Position);
    void updateJumlah(int jumlah);
    void updateharga(int harga);
}