package com.company;

public class Rectangle extends GeometricObject{
    private double x;
    private double y;

    public Rectangle() {

    }

    public Rectangle(String color, double x, double y,String    name) {
        super(color,name);
        this.x = x;
        this.y = y;
    }

    @Override
    public double getArea() {
        return x*y;
    }

    @Override
    public double getPerimeter() {
        return (x+x+y+y);
    }
}
