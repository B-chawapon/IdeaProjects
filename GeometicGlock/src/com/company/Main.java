package com.company;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Triangle t1 = new Triangle("red" , 9 ,10 ,11);
        System.out.println(t1.area());
        System.out.println(t1.perimeter());
        System.out.println(t1.isFilled());
        ArrayList<GeometricObject> geo = new ArrayList<GeometricObject>();
        System.out.println("-----------");
        geo.add(new Circles("white" , 7));
        geo.add(new Triangle("red" , 3,4,5));
        geo.add(new Rectangles("green" , 3 ,4));
        System.out.println(sumArea(geo));

    }

    public static double sumArea(ArrayList<GeometricObject> b){
        double sum=0;
        for(int i = 0 ; i < b.size() ; i++){
            sum += b.get(i).area();
        }
        return sum;
    }


}
