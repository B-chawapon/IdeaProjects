package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner scanner = new Scanner(System.in);
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
        ComparableCircle c1 = new ComparableCircle("green",2.5,"c1");
        ComparableCircle  c2 = new ComparableCircle("red",  5.5,"c2");

        System.out.println(c1.getArea());
        System.out.println(c2.getArea());
        System.out.println(GeometricObject.max(c1,c2));
        //System.out.println(c1.compareTo(c2));


        
        String  want=scanner.nextLine();

        ComparableCircle c3 = null;
        if(want.equals("c1")){
            c3=(ComparableCircle) c1.clone();
            System.out.println("c1==c3 is : "+(c1==c3) );
            System.out.println("c1.equalsc3 : "+ (c1.equals(c3)));
            System.out.println(c3.getArea());
            c3.setName("c3");
        }
        else if(want.equals("c2")){
            c3=(ComparableCircle) c2.clone();
            System.out.println("c2==c3 is : "+(c2==c3) );
            System.out.println("c2.equalsc3 : "+ (c2.equals(c3)));
            System.out.println(c3.getArea());
            c3.setName("c3");
        };
        String a = scanner.nextLine();
        String  b = scanner.nextLine();
        if(a.equals("c1")&&b.equals("c2")){
            System.out.println(GeometricObject.max(c1,c2));
        }
        if(a.equals("c2")&&b.equals("c1")){
            System.out.println(GeometricObject.max(c2,c1));
        }
        if(a.equals("c1")&&b.equals("c3")){
            System.out.println(GeometricObject.max(c1,c3));
        }
        if(a.equals("c3")&&b.equals("c1")){
            System.out.println(GeometricObject.max(c1,c3));
        }
        if(a.equals("c2")&&b.equals("c3")){
            System.out.println(GeometricObject.max(c2,c3));
        }
        if(a.equals("c3")&&b.equals("c2")){
            System.out.println(GeometricObject.max(c2,c3));
        }

        //////
        ComparableRetangle r1 = new ComparableRetangle("green",4,6,"r1");
        ComparableRetangle  r2 = new ComparableRetangle("red",  6,4,"r2");

        System.out.println(r1.getArea());
        System.out.println(r2.getArea());
        System.out.println(GeometricObject.max(r1,r2));
        //System.out.println(c1.compareTo(c2));



        String  wantRe=scanner.nextLine();

        ComparableRetangle r3 = null;
        if(wantRe.equals("r1")){
            r3=(ComparableRetangle) r1.clone();
            System.out.println("r1==r3 is : "+(r1==r3) );
            System.out.println("r1.equalsr3 : "+ (r1.equals(r3)));
            System.out.println(r3.getArea());
            r3.setName("r3");
        }
        else if(wantRe.equals("r2")){
            r3=(ComparableRetangle) r2.clone();
            System.out.println("r2==r3 is : "+(r2==r3) );
            System.out.println("r2.equalsr3 : "+ (r2.equals(r3)));
            System.out.println(r3.getArea());
            r3.setName("r3");
        };
        String x = scanner.nextLine();
        String  c = scanner.nextLine();
        if(x.equals("r1")&&c.equals("r2")){
            System.out.println(GeometricObject.max(r1,r2));
        }
        if(x.equals("r2")&&c.equals("r1")){
            System.out.println(GeometricObject.max(r2,r1));
        }
        if(x.equals("r1")&&c.equals("r3")){
            System.out.println(GeometricObject.max(r1,r3));
        }
        if(x.equals("r3")&&c.equals("r1")){
            System.out.println(GeometricObject.max(r1,r3));
        }
        if(x.equals("r2")&&c.equals("r3")){
            System.out.println(GeometricObject.max(r2,r3));
        }
        if(x.equals("r3")&&c.equals("r2")){
            System.out.println(GeometricObject.max(r2,r3));
        }









    }
    public static double sumArea(ArrayList<GeometricObject> a){
        double sumarea=0;
        for (int i=0;  i<a.size(); i++){
            sumarea+=a.get(i).getArea();
        }


        return sumarea;
    }

}
