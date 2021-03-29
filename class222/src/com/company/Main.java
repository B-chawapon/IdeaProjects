package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner keyboard = new Scanner(System.in);
        Scanner input = new Scanner(System.in);

        RegularPolygon a1=new RegularPolygon();
        RegularPolygon a2=new RegularPolygon(6,4);
        RegularPolygon a3=new RegularPolygon(10,4,5.6,7.8);
        System.out.println("perimeter  "+a1.getPerimeter());
        System.out.println("area  "+a1.getArea());
        System.out.println("perimeter  "+a2.getPerimeter());
        System.out.println("area  "+a2.getArea());
        System.out.println("perimeter  "+a3.getPerimeter());
        System.out.println("area  "+a3.getArea());
    }
}
