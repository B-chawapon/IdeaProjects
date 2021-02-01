package com.company;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        GregorianCalendar testObj= new GregorianCalendar();

        System.out.println("Current");
        System.out.println("Year  "+testObj.get(GregorianCalendar.YEAR));
        System.out.println("Month  "+testObj.get(GregorianCalendar.MONTH));
        System.out.println("Date  "+testObj.get(GregorianCalendar.DATE));
        System.out.println("Day of week  "+testObj.get(GregorianCalendar.DAY_OF_WEEK));


        System.out.println("----------------------");
        System.out.println("After");
        testObj.setTimeInMillis(testObj.getTimeInMillis()+(24*60*60*1000));
        System.out.println("Year  "+testObj.get(GregorianCalendar.YEAR));
        System.out.println("Month  "+testObj.get(GregorianCalendar.MONTH));
        System.out.println("Date  "+testObj.get(GregorianCalendar.DATE));
        System.out.println("Day of week  "+testObj.get(GregorianCalendar.DAY_OF_WEEK));
        System.out.println(testObj.getTime());

    }
}
