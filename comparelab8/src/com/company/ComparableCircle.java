package com.company;

public class ComparableCircle extends Circle implements Cloneable,Comparable {
    public ComparableCircle() {
    }

    public ComparableCircle(String color, double radius, String name) {
        super(color, radius, name);
    }


    @Override
    public ComparableCircle clone()throws CloneNotSupportedException {
        return (ComparableCircle) super.clone();
    }


   /* public int compareTo(Circle x) {
        if(getRadius()>x.getRadius()){
            return 1;
        }
        else if(getRadius()<x.getRadius()){
            return -1;
        }
        else
            return  0;
    }

    public  static String max(ComparableCircle a, ComparableCircle b) {
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
    }*/




}
