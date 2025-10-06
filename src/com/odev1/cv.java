package com.odev1;

import com.odev1.com.odev1.cv.Deneyim;
import com.odev1.com.odev1.cv.Kisisel;
import com.odev1.com.odev1.cv.Okul;
import com.odev1.com.odev1.cv.Yetenekler;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;

public class cv {
    Kisisel kisisel;
    Okul okul;
    Yetenekler yetenekler;
    Deneyim[] deneyim;

    public cv(String ad, String soyad, String email, String telefon, String adres, String ekBilgi) {
        kisisel = new Kisisel(ad, soyad, email, telefon, adres, ekBilgi);
    }

    public cv (Kisisel kisisel, Okul okul, Yetenekler yetenekler, Deneyim deneyim) {
        kisisel = kisisel;
        okul = okul;
        yetenekler = yetenekler;
        deneyim = deneyim;
    }

    public void Deneyim(int index, String sirketAdi, String pozisyon, String calismaTarih, String basarilar) {
        if (deneyim == null) {
            deneyim = new Deneyim[index + 1];
        }

        if (deneyim.length <= index) {
            Deneyim[] yeniDizi = new Deneyim[index + 1];
            System.arraycopy(deneyim, 0, yeniDizi, 0, deneyim.length);
            deneyim = yeniDizi;
        }

        deneyim[index] = new Deneyim(sirketAdi, pozisyon, calismaTarih, basarilar);
    }

    public void Okul(String okulAdi, String bolum, String okulYili, String ekBasarilar) {
        okul = new Okul(okulAdi, bolum, okulYili, ekBasarilar);
    }

    public void Yetenekler(String beceriler, String diller, String egitimler, String projeler, String basariOdul) {
        yetenekler = new Yetenekler(beceriler, diller, egitimler, projeler, basariOdul);
    }

    public String getDeneyimlerString() {
        String temp = "";
        for (int i = 0; i < deneyim.length; i++) {
            temp += i + "-" + deneyim[i].getSirketAdi();
        }
        return temp;
    }

    public void createPDF(String fileName, String imageName){
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);


        try (PDPageContentStream cs = new PDPageContentStream(
                doc,
                page,
                PDPageContentStream.AppendMode.OVERWRITE,
                true)) {


            PDImageXObject image = PDImageXObject.createFromFile(imageName, doc);
            cs.drawImage(image, 50, 625, 100, 100);

            cs.beginText();

            PDType1Font font = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
            cs.setFont(font, 20);
            cs.newLineAtOffset(175, 700);
            cs.showText(kisisel.getAd() + " " + kisisel.getSoyad());

            font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            cs.newLineAtOffset(0,-20);
            cs.setFont(font,12);
            cs.showText("E-Posta:" + kisisel.getEmail());

            cs.newLineAtOffset(0,-18);
            cs.setFont(font,12);
            cs.showText("Telefon:" + kisisel.getTelefon());

            cs.newLineAtOffset(0,-18);
            cs.setFont(font,12);
            cs.showText("Adres:" + kisisel.getAdres());

            cs.newLineAtOffset(0,-22);
            cs.setFont(font,10);
            cs.showText(kisisel.getEkBilgi());

            font = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
            cs.setFont(font, 17);
            cs.newLineAtOffset(-125, -40);
            cs.showText("Okul");

            font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Okul adi:" + okul.getOkul());

            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Bolum:" + okul.getBolum());

            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Okul yili:" + okul.getOkulYil());

            cs.newLineAtOffset(0,-18);
            cs.setFont(font,13);
            cs.showText("Basarilar:" + okul.getEkBasarilar());


            font = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
            cs.setFont(font, 17);
            cs.newLineAtOffset(0, -40);
            cs.showText("Beceriler");

            font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Bildigim diller:" + yetenekler.getDiller());

            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Basari ve oduler:" + yetenekler.getBasariOdul());

            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Beceriler:" + yetenekler.getBeceriler());

            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Projeler:" + yetenekler.getProjeler());

            cs.newLineAtOffset(0,-20);
            cs.setFont(font,15);
            cs.showText("Aldigim egitimler:" + yetenekler.getEgitimler());

            font = new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
            cs.setFont(font, 17);
            cs.newLineAtOffset(0, -40);
            if(deneyim!=null){
                if(deneyim.length>1)
                    cs.showText("Deneyimler");
                else
                    cs.showText("Deneyimsiz");
            } else
                cs.showText("Deneyimsiz");


            if(deneyim!=null){
                for (int i = 0; i < deneyim.length; i++) {
                    font = new PDType1Font(Standard14Fonts.FontName.HELVETICA);
                    cs.newLineAtOffset(0,-20);
                    cs.setFont(font,13);
                    cs.showText("Calistigim Sirket " + deneyim[i].getSirketAdi() +
                            " Bulundugum pozisyon " + deneyim[i].getPozisyon());

                    cs.newLineAtOffset(0,-20);
                    cs.showText("Calisma tarihleri " + deneyim[i].getCalismaTarih());

                    cs.newLineAtOffset(0,-20);
                    cs.showText("Elde ettigim basarilar " + deneyim[i].getBasarilar());

                    cs.newLineAtOffset(0,-10);
                }
            }

            cs.endText();
            cs.close();

            doc.save("cv.pdf");
            doc.close();

            System.out.println("PDF olusturuldu!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Kisisel getKisisel() { return kisisel; }
    public Okul getOkul() { return okul; }
    public Yetenekler getYetenekler() { return yetenekler; }
    public Deneyim[] getDeneyim(){ return deneyim; }


    //Kisisel
    public String getAd() { return kisisel.getAd(); }
    public void setAd(String ad) { kisisel.setAd(ad); }

    public String getSoyad() { return kisisel.getSoyad(); }
    public void setSoyad(String soyad) { kisisel.setSoyad(soyad); }

    public String getEmail() { return kisisel.getEmail(); }
    public void setEmail(String email) { kisisel.setEmail(email); }

    public String getTelefon() { return kisisel.getTelefon(); }
    public void setTelefon(String telefon) { kisisel.setTelefon(telefon); }

    public String getAdres() { return kisisel.getAdres(); }
    public void setAdres(String adres) { kisisel.setAdres(adres); }

    public String getEkBilgi() { return  kisisel.getEkBilgi(); }
    public void setEkBilgi(String ekBilgi) {kisisel.setEkBilgi(ekBilgi); }

    //Okul
    public String getokul() { return okul.getOkul(); }
    public void setokul(String okulAdi) { okul.setOkul(okulAdi); }

    public String getBolum() { return okul.getBolum(); }
    public void setBolum(String bolum) { okul.setBolum(bolum); }

    public String getOkulYil() { return okul.getOkulYil(); }
    public void setOkulYil(String okulYil) { okul.setOkulYil(okulYil); }

    public String getEkBasarilar() { return okul.getEkBasarilar(); }
    public void setEkBasarilar(String ekBasarilar) { okul.setEkBasarilar(ekBasarilar); }

    //Yetenekler
    public String getBeceriler() { return yetenekler.getBeceriler(); }
    public void setBeceriler(String beceriler) { yetenekler.setBeceriler(beceriler); }

    public String getDiller(){ return yetenekler.getDiller(); }
    public void setDiller(String diller) { yetenekler.setDiller(diller); }

    public String getEgitimler() { return yetenekler.getEgitimler(); }
    public void setEgitimler(String egitimler) { yetenekler.setEgitimler(egitimler); }

    public String getProjeler() { return yetenekler.getProjeler(); }
    public void setProjeler(String projeler) { yetenekler.setProjeler(projeler); }

    public String getBasariOdul() { return yetenekler.getBasariOdul(); }
    public void setBasariOdul(String basariOdul) { yetenekler.setBasariOdul(basariOdul); }

    //Deneyim
    public String getSirketAdi(int index) { return deneyim[index].getSirketAdi(); }
    public void setSirketAdi(int index, String sirketAdi) { deneyim[index].setSirketAdi(sirketAdi); }

    public String getPozisyon(int index) { return deneyim[index].getPozisyon(); }
    public void setPozisyon(int index, String pozisyon) { deneyim[index].setPozisyon(pozisyon); }

    public String getCalismaTarih(int index) { return deneyim[index].getCalismaTarih(); }
    public void setCalismaTarih(int index, String calismaTarih) { deneyim[index].setCalismaTarih(calismaTarih); }

    public String getBasarilar(int index) { return deneyim[index].getBasarilar(); }
    public void setBasarilar(int index, String basarilar) { deneyim[index].setBasarilar(basarilar); }
}
