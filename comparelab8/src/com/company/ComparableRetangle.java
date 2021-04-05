package com.company;

public class ComparableRetangle extends Rectangle implements Comparable,Cloneable{
    public ComparableRetangle() {
    }

    public ComparableRetangle(String color, double x, double y, String name) {
        super(color, x, y, name);
    }

    @Override
    public ComparableRetangle clone()throws CloneNotSupportedException {
        return (ComparableRetangle) super.clone();
    }

    /*public int compareTo(Rectangle x) {
        if(getArea()>x.getArea()){
            return 1;
        }
        else if(getArea()<x.getArea()){
            return -1;
        }
        else
            return  0;
    }

    public  static String max(ComparableRetangle a, ComparableRetangle b) {
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
