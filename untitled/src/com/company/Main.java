/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;
import java.util.Scanner;
/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size for the matrix: ");
        int n = input.nextInt();
        int[][] mat = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                mat[i][j] = (int)(Math.random() * 2);
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        checkRow(mat , n);
        checkColumn(mat , n);
        checkSupDia(mat , n);
        checkDia(mat , n);
        checkSubDia(mat , n);
    }
    public static void checkRow(int[][] mat , int n){
        boolean answer = true;
        boolean failed = true;
        for(int i = 0 ; i < n ; i++){
            int temp = mat[i][0];
            answer = true;
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] != temp){
                    answer = false;
                }
            }
            if(answer == true){
                System.out.println("All " + temp + " s on row " + (i+1));
                failed = false;
            }
        }
        if(failed == true){
            System.out.println("No same numbers on a row");
        }
    }

    public static void checkColumn(int[][] mat , int n){
        boolean answer = true;
        boolean failed = true;
        for(int i = 0 ; i < n ; i++){
            int temp = mat[0][i];
            answer = true;
            for(int j = 0 ; j < n ; j++){
                if(mat[j][i] != temp){
                    answer = false;
                }
            }
            if(answer == true){
                System.out.println("All " + temp + " s on column " + (i+1));
                failed = false;
            }
        }
        if(failed == true){
            System.out.println("No same numbers on a column");
        }
    }

    public static void checkDia(int[][] mat , int n){
        int temp = mat[0][0];
        boolean answer = true;
        for(int i = 1 ; i < n ; i++){
            if(mat[i][i] != temp){
                answer = false;
                break;
            }
        }
        if(answer == true){
            System.out.println("All " + temp + " on the diagonal");
        }
        else {
            System.out.println("No same numbers on the diagonal");
        }
    }

    public static void checkSupDia(int[][] mat , int n){
        int temp = mat[0][1];
        boolean answer = true;
        for(int i = 1 ; i < n - 1 ; i++){
            if(mat[i][i+1] != temp){
                answer = false;
                break;
            }
        }
        if(answer == true){
            System.out.println("All " + temp + " on the  superdiagonal");
        }
        else {
            System.out.println("No same numbers on the  superdiagonal");
        }
    }

    public static void checkSubDia(int[][] mat , int n){
        int temp = mat[1][0];
        boolean answer = true;
        for(int i = 1 ; i < n - 1 ; i++){
            if(mat[i+1][i] != temp){
                answer = false;
                break;
            }
        }
        if(answer == true){
            System.out.println("All " + temp + " on the  superdiagonal");
        }
        else {
            System.out.println("No same numbers on the  superdiagonal");
        }
    }
}