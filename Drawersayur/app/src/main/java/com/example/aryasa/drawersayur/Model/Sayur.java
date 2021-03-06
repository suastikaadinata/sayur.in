package com.example.aryasa.drawersayur.Model;

public class Sayur {
    /**
     * id : 1
     * nama : Wortel
     * jumlah : 3
     * berat : 3
     * harga : 10000
     * foto : sayur/zjPSFLK8lWFJKFiW5o2eW28tPAILziV6TL3Eha4i.jpeg
     * created_at : 2018-06-08 07:03:49
     * updated_at : 2018-06-08 07:03:49
     */

    private int id;
    private String nama;
    private int jumlah;
    private int berat;
    private int harga;
    private String foto;
    private String kuantitas;
    private String created_at;
    private String updated_at;

    public Sayur(String foto, int id, String nama, int harga, int berat, String kuantitas){
        this.foto = foto;
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.berat = berat;
        this.kuantitas = kuantitas;
    }

    public Sayur(int id, int jumlah){
        this.id = id;
        this.jumlah = jumlah;
    }

    public Sayur(String foto, int id, String nama, int harga, int jumlah){
        this.foto = foto;
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public  Sayur(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getBerat() {
        return berat;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getKuantitas() {
        return kuantitas;
    }

    public void setKuantitas(String kuantitas) {
        this.kuantitas = kuantitas;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
