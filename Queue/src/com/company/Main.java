package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Queue q1 = new Queue();
        int k = 0;
        Scanner input = new Scanner(System.in);

                q1.enqueue(1);
                q1.enqueue(2);
                q1.enqueue(3);
                q1.enqueue(4);
                q1.enqueue(5);
                q1.enqueue(6);
                q1.enqueue(7);
                q1.enqueue(8);
                q1.enqueue(9);
                q1.enqueue(10);
                q1.enqueue(11);
                q1.enqueue(12);


                //q1.dequeue();

                for(int i=0;i<12;i++) {
                    q1.dequeue();
                }




                for(int i = 0; i < q1.getSize(); i++) {
                    System.out.println(q1.getElements()[i]);
                }
                System.out.println("SIZE " +q1.getSize());


                System.out.println(q1.empty());


            }


    }

