package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner input=new Scanner(System.in);
        System.out.print("Name = ");
        String name=input.nextLine();
        System.out.print("age = ");
        int age = input.nextInt();
        System.out.print("weight = ");
        double  weight = input.nextDouble();
        System.out.print("feet = ");
        double  feet = input.nextDouble();
        System.out.print("inches = ");
        double  inches = input.nextDouble();

        BMI obj=new BMI(name,age,weight,feet,inches);

        System.out.println(obj.getBMI());
        if(obj.getBMI()<18.5)
        {

            System.out.println("Underweight");
        }
        else if(18.5 <=obj.getBMI() && obj.getBMI()<25.0)
        {

            System.out.println("Normal");
        }
        else if(25.0 <=obj.getBMI() && obj.getBMI()<30.0)
        {

            System.out.println("Overweight");
        }
        else if( obj.getBMI()>=30.0)
        {

            System.out.println("Obase");
        }
    }
}