package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code her
    Scanner myObj = new Scanner(System.in);
    Stock stock1 = new Stock(myObj.nextLine(),myObj.nextLine(),myObj.nextDouble(),myObj.nextDouble());

    System.out.println("Symbol :  "+stock1.symbol);
    System.out.println("Name :  "+stock1.name);
    System.out.println("Previous :  "+stock1.previousClosingPrice);
    System.out.println("Current :  "+stock1.currentPrice);
    System.out.println("Change :  "+stock1.getChangePercent() +"%");
    }
}
