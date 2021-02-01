package com.company;
import java.lang.Math;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner in = new Scanner(System.in);
        int box1=in.nextInt();
        int box2=in.nextInt();
        int[] array1 = new int[box1];
        int[] array2 = new int[box2];

        int i, j;
        for (i = 0; i < array1.length; i++) {
            int rand = (int) (Math.random() * 20);
            array1[i] = rand;
            System.out.print(array1[i] + " ");
        }
        System.out.println();
        for (i = 0; i < array2.length; i++) {
            int rand = (int) (Math.random() * 20);
            array2[i] = rand;
            System.out.print(array2[i]+ " ");
        }
        System.out.println("");

        int[] successful = merge(array1,array2);
        for(j=0;j<successful.length;j++) {
            System.out.print(successful[j]+ " ");
        }


    }

    public static int[] merge(int[] list1, int[] list2)
    {
        int i,j;
        int[] mergelist = new int[list1.length+list2.length];
        for(i = 0; i < list1.length; i++)
        {
            mergelist[i]=list1[i];
        }
        for ( j=0;j<list2.length;j++)
        {
            mergelist[list1.length+j]=list2[j];
        }
        for(j=0;j<mergelist.length;j++) {
            System.out.print(mergelist[j]+ " ");
        }

        mergelist=sortarray(mergelist);

        System.out.println();
        System.out.println("----------------");
        return mergelist;
    }

    public static int[] sortarray(int[] arraysort)
    {
        int temp=0;
        int i,j;
        for( i=0;i<arraysort.length;i++)
        {
            for (j=i+1;j<arraysort.length;j++)
            {
                if(arraysort[i]>arraysort[j])
                {
                    temp=arraysort[i];
                    arraysort[i]=arraysort[j];
                    arraysort[j]=temp;
                }
            }
        }
        return arraysort;
    }

}
