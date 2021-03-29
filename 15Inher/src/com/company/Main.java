package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array= new int[] {1,2,3,4,5,6,7,8,9};
        int[]   array2 = new int[5];
        int[]   output = new int[4];

        for(int i = 0; i <array2.length; i++)
        {
            array2[i] =input.nextInt();
        }
        for(int j = 0; j < array2.length;j++)
        {
            for(int m = 0; m < array.length; m++)
            {
                if(array2[j]==array[m])
                {
                    array[m] =0;
                }
            }
        }
        int x=0;
        for(int k = 0; k < array.length;k++)
        {
            if(array[k]!=0)
            {
                output[x]=array[k];
                x++;
            }

        }

        for(int i = 0; i < output.length; i++){
            System.out.print(output[i] + " ");

        }




    }

}
