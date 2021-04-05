package com.company;
import java.lang.Math;
import java.util.Objects;

public class Circle extends GeometricObject implements Comparable,Cloneable {
    private double radius;
    public Circle() {
    }

    public Circle(String color,double radius,String name) {
        super(color,name);
        this.radius = radius;
    }



    @Override
    protected Circle clone()throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public boolean equals(Object o) {
       if (this.radius == ((Circle)(Circle)o).getRadius()) return true;
      if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }



    public double getRadius() {
        return radius;
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
