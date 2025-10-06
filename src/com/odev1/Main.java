package com.odev1;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        cv cv = new cv("Ayberk Eren", "Kaya", "kayaerenayberk@hotmail.com", "05514173040", "Kirklareli / Turkiye", "Yazilim Muhendisligi Ogrencisi");

        cv.Okul(
                "Kirklareli Universitesi",
                "Yazilim Muhendisligi",
                "2022-2026",
                "3.4 Ortalama, Teknofest Katilimi, Bitirme Projesi: Akilli Tarim Uygulamasi"
        );

        cv.Yetenekler(
                "Takim calismasi, Problem cozme, Kod gelistirme, Yenilikci dusunme",
                "Ingilizce (B2), Rusca (A2)",
                "C, C++, Java, PHP, HTML, CSS, JavaScript, Python",
                "www.ayberkerenkaya.dev",
                "Teknofest 2025 Yapay Zeka Kategorisi Ucunculuk Odulu"
        );

        cv.Deneyim(
                0,
                "Baykar Teknoloji",
                "Yazilim Gelistirici Stajyeri",
                "Temmuz 2025 - Eylul 2025",
                "Gomulu sistemlerde veri isleme uzerine calisti."
        );

        cv.Deneyim(
                1,
                "ASELSAN",
                "Yapay Zeka Muhendisi (Full-Time)",
                "2027 - Gunumuz",
                "Makine ogrenmesi tabanli goruntu isleme projelerinde gorev aldi"
        );

        cv.createPDF("cv","profil.jpg");


    }
}