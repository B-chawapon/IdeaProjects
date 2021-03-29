package com.company;

public class ComparableCircle extends Circle implements Comparable{
    public ComparableCircle() {
    }

    public ComparableCircle(String color, double radius, String name) {
        super(color, radius, name);
    }



    public int compareTo(ComparableCircle x) {
        if(getArea()>x.getArea()){
            return 1;
        }
        else if(getArea()<x.getArea()){
            return -1;
        }
        else
            return  0;
    }
}
