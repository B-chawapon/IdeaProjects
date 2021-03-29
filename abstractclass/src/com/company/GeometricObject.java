package com.company;
import java.util.Date;
import java.util.ArrayList;
import java.util.Objects;

public abstract class GeometricObject implements Comparable  {
    private String  color;
    private boolean filled;
    private String name;

    protected GeometricObject(){

    }
    protected GeometricObject(String color,String   name) {
        this.color = color;
        this.name = name;

    }
    public abstract double getArea();
    public abstract double  getPerimeter();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        if(color=="")
        {
            return false;
        }
        else {
            return true;
        }

    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GeometricObject)) {
            return false;
        }
        GeometricObject that = (GeometricObject) o;
        return isFilled() == that.isFilled() && getColor().equals(that.getColor()) && getName().equals(that.getName());
    }


    @Override
    public int compareTo(GeometricObject x) {
        if(getArea()>x.getArea()){
            return 1;
        }
        else if(getArea()<x.getArea()){
            return -1;
        }
        else
            return  0;
    }

    public  static String max(GeometricObject a, GeometricObject b) {
        if(a.compareTo(b)==1){
            return a.getName();
        }
        else if(a.compareTo(b)==-1){

            return b.getName();
        }
        else
        {
           return "EQUAL";
        }
    }
}
