package com.company;

public abstract class GeometricObject {
    String color;
    boolean filled;

    public GeometricObject(){}

    public GeometricObject(String color) {
        this.color = color;

    }
    public boolean isFilled(){
        if(color == ""){
            return false;
        }
        else{
            return true;
        }
    }

    public abstract double area();
    public abstract double perimeter();

}
