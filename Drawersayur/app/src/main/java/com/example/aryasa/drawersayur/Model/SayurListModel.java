package com.example.aryasa.drawersayur.Model;

public class SayurListModel {
    private String nama_sayur_admin_list;
    private String harga_sayur_admin_list;
    private int  gambar_sayur_admin_list;

    public SayurListModel(String nama_sayur_admin_list, String harga_sayur_admin_list, Integer gambar_sayur_admin_list){
        this.harga_sayur_admin_list= harga_sayur_admin_list;
        this.nama_sayur_admin_list= nama_sayur_admin_list;
        this.gambar_sayur_admin_list= gambar_sayur_admin_list;

    }
    public SayurListModel(){
    }

    public String getHarga_sayur_admin_list() {
        return harga_sayur_admin_list;
    }

    public int getGambar_sayur_admin_list() {
        return gambar_sayur_admin_list;
    }

    public String getNama_sayur_admin_list() {
        return nama_sayur_admin_list;
    }

    public void setGambar_sayur_admin_list(int gambar_sayur_admin_list) {
        this.gambar_sayur_admin_list = gambar_sayur_admin_list;
    }

    public void setNama_sayur_admin_list(String nama_sayur_admin_list) {
        this.nama_sayur_admin_list = nama_sayur_admin_list;
    }

    public void setHarga_sayur_admin_list(String harga_sayur_admin_list) {
        this.harga_sayur_admin_list = harga_sayur_admin_list;
    }
}
