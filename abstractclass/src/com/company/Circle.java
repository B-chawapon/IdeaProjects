package com.company;
import java.lang.Math;
public class Circle extends GeometricObject implements Comparable {
    private double radius;
    public Circle() {
    }

    public Circle(String color,double radius,String name) {
        super(color,name);
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return Math.PI*(radius*radius);
    }

    @Override
    public double getPerimeter() {
        return Math.PI*radius*2;
    }
}
