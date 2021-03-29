package com.company;

public class Main {

    public static void main(String[] args) {
        Circle c1 = new Circle();
        c1.setRadius(2.5);
        c1.setColor("Red");
        c1.setFilled(true);
        double areaC1=c1.getArea();


        Rectangle r1 = new Rectangle();
        System.out.println(r1.getColor());
        Rectangle r2 = new Rectangle("BLUE",true,1.5,3.5);
        System.out.println(r2.getColor());
        System.out.println(r1.getDataCreated());


    }
}
