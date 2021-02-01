package com.company;

import java.util.Scanner;


public class Main {
    public static int pass;
    public static int passtoend;
    public static void main(String[] args) {

        int cout = 0;
        while (true) {
            palin(cout);
            if(pass==10)
            {
                System.out.println();
                pass=0;
                passtoend++;
            }
            if(passtoend==10)
            {
                break;
            }
            cout++;
        }
    }
    public static void palin(int num)
    {
        int posfront = num;
        int posback = 0;
        int temp = 0;
        while (num != 0) {
            temp = num % 10;
            //System.out.println(temp);
            posback = posback * 10 + temp;
            //System.out.println(posback);
            num /= 10;
            //System.out.println(num);
        }
        if (posfront == posback) {
            prime(posfront);
        }
    }

    public static void prime(int num) {
        int i;
        boolean check = false;

        for (i = 2; i <= num / 2; ++i) {

            if (num % i == 0) {
                check = true;
                break;
            }
        }
        if (num >= 2 && check == false)
        {
            System.out.print(num +" ");
            pass++;
        }
    }
}
