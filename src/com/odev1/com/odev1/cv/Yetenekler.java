package com.odev1.com.odev1.cv;

public class Yetenekler {
    private String beceriler;
    private String diller;
    private String egitimler;
    private String projeler;
    private String basariOdul;

    public Yetenekler(String beceriler, String diller, String egitimler, String projeler, String basariOdul){
        this.beceriler = beceriler;
        this.diller = diller;
        this.egitimler = egitimler;
        this.projeler = projeler;
        this.basariOdul = basariOdul;
    }

    public String getBeceriler() { return beceriler; }
    public void setBeceriler(String beceriler) { this.beceriler = beceriler; }

    public String getDiller(){ return diller; }
    public void setDiller(String diller) { this.diller = diller; }

    public String getEgitimler() { return egitimler; }
    public void setEgitimler(String egitimler) { this.egitimler = egitimler; }

    public String getProjeler() { return projeler; }
    public void setProjeler(String projeler) { this.projeler = projeler; }

    public String getBasariOdul() { return basariOdul; }
    public void setBasariOdul(String basariOdul) { this.basariOdul = basariOdul; }
    
}
