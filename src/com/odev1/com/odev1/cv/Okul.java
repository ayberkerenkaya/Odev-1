package com.odev1.com.odev1.cv;

public class Okul {
    private String okul;
    private String bolum;
    private String okulYil;
    private String ekBasarilar;

    public Okul(String okul, String bolum, String okulYil, String ekBasarilar){
        this.okul = okul;
        this.bolum = bolum;
        this.okulYil = okulYil;
        this.ekBasarilar = ekBasarilar;
    }

    public String getOkul() { return okul; }
    public void setOkul(String okulAdi) { this.okul = okulAdi; }

    public String getBolum() { return bolum; }
    public void setBolum(String bolum) { this.bolum = bolum; }

    public String getOkulYil() { return okulYil; }
    public void setOkulYil(String okulYil) { this.okulYil = okulYil; }

    public String getEkBasarilar() { return ekBasarilar; }
    public void setEkBasarilar(String ekBasarilar) { this.ekBasarilar = ekBasarilar; }
}
