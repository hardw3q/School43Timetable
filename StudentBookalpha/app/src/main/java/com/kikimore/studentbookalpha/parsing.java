package com.kikimore.studentbookalpha;


import android.net.Uri;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class parsing{
   private static final java.lang.String urlunn = "https://enter.unn.ru/preport/school/";
    private static final java.lang.String clacc = "class/";
    private static final java.lang.String teacher = "teacher/";
    private static final java.lang.String classroom = "cabinet/";
    private static final java.lang.String url_ad = "https://enter.unn.ru/preport/school/class/1.html";
    private static String ctc;
    private static String nit;

    public static String URLConstructor(int path, int classnumber) {
        Uri builturi = Uri.parse(parsing.urlunn + getCtc(path) + classnumber + ".html");
        URL url = null;
        try {
            url = new URL(builturi.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return String.valueOf(url);
    }

    private static String getCtc(int path){
        switch(path){
            case(0):
                nit = clacc;
                break;
            case(1):
                nit = teacher;
                break;
            case(2):
                nit = classroom;
                break;
        }
        return nit;
    }
}

