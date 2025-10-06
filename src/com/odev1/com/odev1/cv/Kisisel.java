package com.odev1.com.odev1.cv;

public class Kisisel {
    private String ad;
    private String soyad;
    private String email;
    private String telefon;
    private String adres;
    private String ekBilgi;

    public Kisisel(String ad, String soyad, String email,String telefon, String adres, String ekBilgi){
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.telefon = telefon;
        this.adres = adres;
        this.ekBilgi = ekBilgi;
    }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getAdres() { return adres; }
    public void setAdres(String adres) { this.adres = adres; }

    public String getEkBilgi() { return ekBilgi; }
    public void setEkBilgi(String ekBilgi) { this.ekBilgi = ekBilgi; }
}
