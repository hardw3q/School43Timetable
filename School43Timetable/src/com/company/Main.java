package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;
public class Main {
    static String url = "https://enter.unn.ru/preport/school/class/2.html";
    private static final java.lang.String urlunn = "https://enter.unn.ru/preport/school/";
    private static final java.lang.String clacc = "class/";
    private static final java.lang.String teacher = "teacher/";
    private static final java.lang.String classroom = "cabinet/";
    private static String nit;
    private static int stopintent = 0;
    public static void main(String[] args){
        Scanner inf = new Scanner(System.in);
        while (stopintent == 0) {
            System.out.println("Введите номер урока");
            int numberoflesson = inf.nextInt()-1;
            System.out.println("Номер дня недели");
            int dayofweek = inf.nextInt()-1;
            System.out.println("Введите номер фильтра(Класс - 0)");
            int path = inf.nextInt();
            System.out.println("Введите номер класса(9А - 37)");
            int classnumber = inf.nextInt();
            for (String a : getStrings(numberoflesson, dayofweek, path, classnumber)) {
                System.out.println(a);
            }
            System.out.println("Для продолжения введите ноль");
            stopintent = inf.nextInt();
        }
    }
    public static String[] getStrings(int numberoflesson, int dayofweek,int path, int classnumber){

        Document doc = null;
        try {
            doc = Jsoup.connect(getUrl(path, classnumber))
                        .get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        final Elements getTimetableColumn = doc.select("div.timetable-column");

        Elements getLastRasp = getTimetableColumn.get(dayofweek).select("div.timetable-name");
        String rasp = getLastRasp.get(numberoflesson).text();

        Elements getLastCab = getTimetableColumn.get(dayofweek).select("div.timetable-title-wrap > div.timetable-time");
        String Cab = getLastCab.get(numberoflesson).text();

        Elements getLastYchitel = getTimetableColumn.get(dayofweek).select("div.timetable-desc > p:lt(1)");
        String ychitel = getLastYchitel.get(numberoflesson).text();
        Elements getLastTime = getTimetableColumn.get(dayofweek).select("div.timetable-desc > p:eq(2)");
        String time = getLastTime.get(numberoflesson).text();
        return new String[]{rasp, Cab, ychitel, time};
    }
    public static String getUrl(int path,int classnumber){
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
        URI builturi = URI.create(urlunn + nit + classnumber + ".html");
        URL url = null;
        try {
            url = new URL(builturi.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return String.valueOf(url);
    }
}
