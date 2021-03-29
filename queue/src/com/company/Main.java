package com.company;
import java.util.Stack;
public class Main {

    public static void main(String[] args) {
	// write your code here
    Queue   q1=new Queue();


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

    q1.dequeue();
    int[] value= q1.getQueue();
    for (int i=0; i<value.length; i++)
    {
        System.out.println(value[i]);
    }




    }
}
