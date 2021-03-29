package com.company;

public class Rectangles extends GeometricObject{
    private double x;
    private double y;
    public Rectangles(){}
    public Rectangles(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Rectangles(String color, double x, double y) {
        super(color);
        this.x = x;
        this.y = y;
    }

    @Override
    public double area() {
        return x*y;
    }

    @Override
    public double perimeter() {
        return 2*(x+y);
    }
}
