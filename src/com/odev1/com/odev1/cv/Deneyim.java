package com.odev1.com.odev1.cv;

public class Deneyim {
    private String sirketAdi;
    private String pozisyon;
    private String calismaTarih;
    private String basarilar;

    public Deneyim(String sirketAdi, String pozisyon, String calismaTarih,String basarilar){
        this.sirketAdi = sirketAdi;
        this.pozisyon = pozisyon;
        this.calismaTarih = calismaTarih;
        this.basarilar = basarilar;
    }

    public String getSirketAdi() { return sirketAdi; }
    public void setSirketAdi(String sirketAdi) { this.sirketAdi = sirketAdi; }

    public String getPozisyon() { return pozisyon; }
    public void setPozisyon(String pozisyon) { this.pozisyon = pozisyon; }

    public String getCalismaTarih() { return calismaTarih; }
    public void setCalismaTarih(String calismaTarih) { this.calismaTarih = calismaTarih; }

    public String getBasarilar() { return basarilar; }
    public void setBasarilar(String basarilar) { this.basarilar = basarilar; }
}
