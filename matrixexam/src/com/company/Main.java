package com.company;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int samerow=0;
    public static int samecolumn=0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [][]matrix = new int[5][5];
        //int rand = (int) Math.random();

        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length;j++)
            {
                matrix[i][j]= (int)(Math.random()*10)%2;
            }
        }
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length;j++)
            {
                if(j%5==0)
                {
                    System.out.println("");
                }
                System.out.print(matrix[i][j]);

            }
        }

        int[] counter=new int[5];
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length;j++)
            {
                if(matrix[i][j]==1)
                {
                    counter[i]++;
                }

            }
        }

        int[] countercolumn=new int[5];
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < matrix.length;j++)
            {
                if(matrix[j][i]==0)
                {
                    countercolumn[i]++;
                }

            }
        }

        System.out.println("");
        //for (int i = 0; i < counter.length; i++) {
       //     System.out.println(countercolumn[i] + "");
        //}

        int x=0;
        for (int i = 0; i < counter.length; i++) {

            if(counter[i]==getMinValue(counter))
            {
                x=i;
                samerow++;
                if(samerow>=2)
                {
                    System.out.println("No");
                    break;
                }
            }

        }
        if(counter[x]==getMinValue(counter)) {
            if(samerow<2) {
                System.out.println(" Row YES, " + (1 + x));
            }
        }

        int y=0;
        for (int i = 0; i < counter.length; i++) {

            if(countercolumn[i]==getMinValue(counter))
            {
                y=i;
                samecolumn++;
                if(samecolumn>=2)
                {
                    System.out.println("No");
                    break;
                }
            }

        }
        if(countercolumn[y]==getMinValue(counter)) {
            if(samecolumn<2) {
                System.out.println(" colum YES, " + (1 + y));
            }
        }






    }
    public static int getMinValue(int[] array2){

        int minValue = array2[0];
        for(int i=1;i<array2.length;i++){
            if(array2[i] < minValue){
                minValue = array2[i];

            }

        }
        return minValue;
    }
}
