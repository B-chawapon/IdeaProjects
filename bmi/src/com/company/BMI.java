package com.company;
import java.lang.Math;
public class BMI {
    private String name;
    private int age;
    private double  weight;
    private double  feet;
    private double  inches;
    private double height=0;

     final double POUNDS =0.45359237;
     final double INCH =0.0254;

    public BMI(String name,int age,double weight,double feet,double inches){
        this.name=name;
        this.age=age;
        this.weight=weight;
        this.feet=feet;
        this.inches=inches;


    }
    public double getBMI()
    {
       // System.out.println(weight*POUNDS/Math.pow(((feet*12)+inches)*INCH,2));
        return  weight*POUNDS/Math.pow(((feet*12)+inches)*INCH,2) ;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getFeet() {
        return feet;
    }

    public void setFeet(double feet) {
        this.feet = feet;
    }

    public double getInches() {
        return inches;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }
}
