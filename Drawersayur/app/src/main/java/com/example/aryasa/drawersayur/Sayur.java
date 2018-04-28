package com.example.aryasa.drawersayur;

public class Sayur {
    private String nama_sayur;
    private String harga_sayur;
    private int  gambar_sayur;

    public Sayur(String nama_sayur, String harga_sayur, Integer gambar_sayur){
        this.harga_sayur= harga_sayur;
        this.nama_sayur= nama_sayur;
        this.gambar_sayur= gambar_sayur;

    }
    public Sayur(){
    }

    public String getHarga_sayur() {
        return harga_sayur;
    }

    public int getGambar_sayur() {
        return gambar_sayur;
    }

    public String getNama_sayur() {
        return nama_sayur;
    }

    public void setGambar_sayur(int gambar_sayur) {
        this.gambar_sayur = gambar_sayur;
    }

    public void setNama_sayur(String nama_sayur) {
        this.nama_sayur = nama_sayur;
    }

    public void setHarga_sayur(String harga_sayur) {
        this.harga_sayur = harga_sayur;
    }
}
