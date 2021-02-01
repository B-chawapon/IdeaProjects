package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner(System.in);
        int box=in.nextInt();
        int i,j;
        int[][] matrix = new int[box][box];
        for (i = 0; i < matrix.length; i++) {
            for (j = 0;j<matrix.length; j++)
            {
                int rand = (int) (Math.random() * 10);
                matrix[i][j] = rand%2;
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        row(matrix);
        colum(matrix);
        diagonal(matrix);
        superdiagonal(matrix);
        subdiagonal(matrix);
    }

    public static void row(int[][] rowtrix)
    {
        int i,j;
        int coutrow=0;
        int value=0;
        boolean hasans=true;
        boolean checkfail=true;
        for (i = 0; i < rowtrix.length;i++){
            value=rowtrix[i][0];
            hasans=true;
            for (j = 0; j < rowtrix.length;j++) {
                if (rowtrix[i][j] != value) {
                    hasans = false;
                    break;
                }
            }
                if(hasans==true)
                {
                    checkfail=false;
                    System.out.println("ALL "+ value+"s on row"+ (1+i));
                }

        }
        if(checkfail==true)
        {
            System.out.println("No same numbers on row");
        }
    }
    public static void colum(int[][] columtrix)
    {
        int i,j;
        int coutcolum=0;
        int value=0;
        boolean hasans=true;
        boolean checkfail=true;
        for (i = 0; i < columtrix.length;i++){
            value=columtrix[0][i];
            hasans=true;
            for (j = 0; j < columtrix.length;j++) {
                if (columtrix[j][i] != value) {
                    hasans = false;
                    break;
                }
            }
                if(hasans==true)
                {
                    checkfail=false;
                    System.out.println("ALL "+ value+"s on colum"+ (1+i));
                }

        }
        if(checkfail==true)
        {
            System.out.println("No same numbers on colum");

        }
    }

    public static void diagonal(int[][] diago)
    {
        int i;
        int value=diago[0][0];
        boolean hasans=true;
        for (i=0;i<diago.length;i++)
        {
            if(diago[i][i]!=value)
            {
                hasans = false;
                break;
            }
        }
        if(hasans==true){
            System.out.println("ALL "+ value+" on diagonal");
        }
        else {
            System.out.println("No diagonal");
        }

    }

    public static void superdiagonal(int[][] supertrix){
        int i;
        int value = supertrix[0][1];
        boolean hasans = true;
        for( i = 1 ; i < supertrix.length-1; i++){
            if(supertrix[i][i+1] != value){
                hasans = false;
                break;
            }
        }
        if(hasans == true){
            System.out.println("ALL " + value + " on the  superdiagonal");
        }
        else {
            System.out.println("No superdiagonal");
        }
    }

    public static void subdiagonal(int[][] subtrix){
        int i;
        int value = subtrix[1][0];
        boolean hasans = true;
        for( i = 1 ; i < subtrix.length-1; i++){
            if(subtrix[i+1][i] != value){
                hasans = false;
                break;
            }
        }
        if(hasans == true){
            System.out.println("ALL " + value + " on the  subdiagonal");
        }
        else {
            System.out.println("No subdiagonal");
        }
    }



}
