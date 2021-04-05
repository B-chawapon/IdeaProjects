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
    protected Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this.getArea() == ((Rectangle)(Rectangle)o).getArea()) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle circle = (Rectangle) o;
        return Double.compare(circle.getArea(), getArea()) == 0;
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
