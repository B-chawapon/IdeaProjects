package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input = new Scanner(System.in);
        Person p1=new Person();


        System.out.print("Enter Name : ");
        p1.setName(input.nextLine());
        //System.out.print(s1.getName());
        System.out.print("Enter address : ");
        p1.setAddress(input.nextLine());
        System.out.print("Enter phone number : ");
        p1.setPhoneNumber(input.nextLine());
        System.out.print("Enter email : ");
        p1.setEmailAddress(input.nextLine());


        Student st1 = new Student();
        System.out.print("Enter status : ");
        st1.setstatus(input.nextInt());

        Employee e1= new Employee();
        System.out.print("Enter Name : ");
        e1.setName(input.nextLine());
        System.out.print("Enter address : ");
        e1.setAddress(input.nextLine());
        System.out.print("Enter phone number : ");
        e1.setPhoneNumber(input.nextLine());
        System.out.print("Enter email : ");
        e1.setEmailAddress(input.nextLine());
        System.out.print("Enter office : ");
        e1.setOffice(input.nextLine());
        System.out.print("Enter salary : ");
        e1.setSalary(input.nextDouble());

       Faculty f1= new Faculty(100,"S");
       Staff   staff1=new Staff("HEADER");





        System.out.println(p1.toString() + st1.toString());
        System.out.println(e1.toString());

        System.out.println(f1.toString());
        System.out.println(staff1.toString());








    }
}
