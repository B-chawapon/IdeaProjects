package com.company;
import java.lang.Math;
public class Circles extends GeometricObject{
    double radius;
    public Circles(){

    }
    public Circles(double radius) {
        this.radius = radius;
    }

    public Circles(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }
}
