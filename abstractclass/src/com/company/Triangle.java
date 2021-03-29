package com.company;
import java.lang.Math;
public class Triangle extends GeometricObject {
    private double a;
    private double b;
    private double c;
    public Triangle() {
    }
    public Triangle(String color, double a, double b, double c,String   name) {
        super(color,name);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public double getPerimeter() {
        return a+b+c;
    }



}
