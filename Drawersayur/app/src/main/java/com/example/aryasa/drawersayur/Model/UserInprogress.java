package com.example.aryasa.drawersayur.Model;

public class UserInprogress {
    private String textView_barang1;
    private String textView_barang2;
    private String textView_barang3;
    private int imageView,id;
    private String textView_tanggal;
    private String textView_jam, status,metode,alamat,nomor,namauser,idtransaksi;

    public UserInprogress(String idtransaksi,String namauser,String status, String nomor,String waktu,String alamat){
        this.status =status;
        this.nomor = nomor;
        this.textView_tanggal =waktu;
        this.alamat = alamat;
        this.namauser =namauser;
        this.idtransaksi=idtransaksi;
    }

    public String getTextView_barang1() { return textView_barang1; }

    public String getTextView_barang2() {
        return textView_barang2;
    }

    public String getTextView_barang3() {
        return textView_barang3;
    }

    public int getImageView() { return imageView; }

    public String getTextView_jam() { return textView_jam; }

    public String getTextView_tanggal() {
        return textView_tanggal;
    }

    public String getMetode() {
        return metode;
    }

    public String getStatus() {
        return status;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNamauser() {
        return namauser;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public void setNamauser(String namauser) {
        this.namauser = namauser;
    }

    public void setTextView_barang1(String textView_barang1) {
        this.textView_barang1 = textView_barang1;
    }

    public void setTextView_barang2(String textView_barang2) {
        this.textView_barang2 = textView_barang2;
    }

    public void setTextView_barang3(String textView_barang3) {
        this.textView_barang2 = textView_barang3;
    }

    public void setTextView_jam(String textView_jam) {
        this.textView_jam = textView_jam;
    }

    public void setTextView_tanggal(String textView_tanggal) {
        this.textView_tanggal = textView_tanggal;
    }

    public void  setStatus(String status){
        this.status=status;
    }
    public void setMetode(String metode){
        this.metode=metode;
    }
    public  void  setAlamat(String alamat){
        this.alamat = alamat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setIdtransaksi(String idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    public String getIdtransaksi() {
        return idtransaksi;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }


}
