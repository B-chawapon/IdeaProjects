package com.company;
import java.lang.Math;
public class Circle extends Geometric{
    double radius;
    public Circle(){}

    public Circle(double radius)
    {
        this.radius = radius;
    }
    public Circle(double radius,String color,boolean isFilled){
        super(color,isFilled);
        this.radius = radius;

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI* Math.pow(radius,2);
    }
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

}
