package com.example.aryasa.drawersayur.Model;

public class UserInprogress {
    private String textView_barang1;
    private String textView_barang2;
    private String textView_barang3;
    private int imageView;
    private String textView_tanggal;
    private String textView_jam;

    public UserInprogress(String textView_barang1, String textView_barang2 ,String textView_barang3, Integer imageView,String textView_tanggal,String textView_jam){
        this.textView_barang1= textView_barang1;
        this.textView_barang2= textView_barang2;
        this.textView_barang3= textView_barang3;
        this.imageView= imageView;
        this.textView_tanggal= textView_tanggal;
        this.textView_jam= textView_jam;

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


    public void setImageView(int imageView) {
        this.imageView = imageView;
    }


}
