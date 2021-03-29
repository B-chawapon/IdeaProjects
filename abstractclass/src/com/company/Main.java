package com.company;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
	// write your code here
       /* Triangle t1=new Triangle("",9,10,11);
        System.out.println(t1.getArea());
        System.out.println(t1.getPerimeter());
        System.out.println(t1.getColor());
        System.out.println(t1.isFilled());

        ArrayList<GeometricObject> g1= new ArrayList<GeometricObject>();
        g1.add(new Circle("BLUE",4));
        g1.add(new Rectangle("RED",4,5));
        g1.add(new Triangle("White",9,10,11));

        for(int i=0; i <g1.size(); i++)
        {
            System.out.println(g1.get(i).getArea());
        }


        System.out.println("sumarea= " +sumArea(g1));*/


        //3.1
        Circle c1 = new ComparableCircle("green",2.5,"c1");
        Circle  c2 = new ComparableCircle("red",  5.5,"c2");
        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
        System.out.println(GeometricObject.max(c1,c2));
        System.out.println(c1.compareTo(c2));




    }
    public static double sumArea(ArrayList<GeometricObject> a){
        double sumarea=0;
        for (int i=0;  i<a.size(); i++){
            sumarea+=a.get(i).getArea();
        }


        return sumarea;
    }

}
