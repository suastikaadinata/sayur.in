package com.example.aryasa.drawersayur.Model;

public class Userdata {
    private String txt_username;
    private String txt_email;
    private String txt_notelp;
    private int gambaruser;

    public Userdata(String txt_username, String txt_email,String txt_notelp, Integer gambar_user){
        this.txt_username= txt_username;
        this.txt_email= txt_email;
        this.txt_notelp= txt_notelp;
        this.gambaruser= gambar_user;

    }


    public String getTxt_username() { return txt_username; }

    public String getTxt_email() {
        return txt_email;
    }

    public String getTxt_notelp() {
        return txt_notelp;
    }

    public int getGambaruser() { return gambaruser; }


    public void setTxt_username(String txt_username) {
        this.txt_username = txt_username;
    }

    public void setTxt_email(String txt_email) {
        this.txt_email = txt_email;
    }

    public void setTxt_notelp(String txt_notelp) {
        this.txt_notelp = txt_notelp;
    }

    public void setGambaruser(int gambar_user) {
        this.gambaruser = gambar_user;
    }


}
