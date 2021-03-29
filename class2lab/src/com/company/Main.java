package com.company;
import java.util.Date;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here

        Account ac1 =new Account(1122,20000);
        Scanner input =new Scanner(System.in);


            ac1.setMonthlyInterestRate(4.5);

            System.out.println("ID " + ac1.getID());
            System.out.println("balance " + ac1.getbalance());
            System.out.println("annual rate " + ac1.getMonthlyInterestRate() + "%");


            System.out.print("withdraw ");
            System.out.println(ac1.withDraw(input.nextInt()));
            System.out.println("balance " + ac1.getbalance());

            System.out.print("deposit ");
            System.out.println(ac1.deposit(input.nextInt()));
            System.out.println("balance " + ac1.getbalance());
            System.out.println("Interrest " + ac1.getMonthlyInterest());
            System.out.println(ac1.getDataCreated());


    }
}
