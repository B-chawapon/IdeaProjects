package com.company;
import java.util.Scanner;
import java.util.Date;
public class Main {

    public static void main(String[] args) {
	// write your code here
        CheckingAccount ch1 = new CheckingAccount(112,5000,5000);
        System.out.println("Balance " +ch1.getBalance());
        System.out.println("OVerdraft " +ch1.getOverdraftLimit());


        ch1.withDraw(10000);
        System.out.println("Balance " +ch1.getBalance());
        System.out.println(ch1.getDataCreated());

        SavingsAccount sv1=new SavingsAccount(001,5000);

        System.out.println("Balance " +sv1.getBalance());

        sv1.withDraw(1000);
        System.out.println("Balance " +sv1.getBalance());
        System.out.println(sv1.getDataCreated());



    }
}
