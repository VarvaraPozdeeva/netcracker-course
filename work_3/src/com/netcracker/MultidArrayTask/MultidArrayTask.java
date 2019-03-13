package com.netcracker.MultidArrayTask;

import java.util.Arrays;
import java.util.Random;

public class MultidArrayTask {
    public static void main(String[] args) {
        taskA();
        taskB();
        taskC();
        taskD();
    }
    static void taskA(){
        System.out.println("Task a");
        Random random = new Random();
        int n =8;
        int [][] buf = new int[n][n];
        for(int i=0; i<n; i++ ){
            for(int j=0; j<n; j++){
                buf[i][j] = random.nextInt(99)+1;
            }
        }
        int sum =0;
        int sum2=0;
        for(int i =0; i<n; i++){
            sum += buf[i][i];
            sum2 += buf[i][n-1-i];
        }
        System.out.println("Sum of main diagonal = "+sum);
        System.out.println("Sum of side diagonal = "+sum2);
        System.out.println();

    }
    static void taskB(){
        System.out.println("Task b.");
        Random random = new Random();
        int nCol = 5;
        int nRow =8;
        int[][] buf = new int[nRow][nCol];
        int max = -100;
        int maxR =-1, maxC = -1;
        for(int i=0; i< nRow; i++){
            for(int j=0; j< nCol; j++){
                buf[i][j] = random.nextInt(199)-99;
                System.out.print(buf[i][j] + "\t");
                if(max<buf[i][j]){
                    max = buf[i][j];
                    maxR = i;
                    maxC = j;
                }
            }
            System.out.println();
        }
        System.out.println("Max is buf[" + maxR +"][" + maxC + "] = "+ max);
        System.out.println();

    }
    static void taskC(){
        System.out.println("Task c.");
        Random random = new Random();
        int maxIndex =-1;
        int maxMult=1;
        int nCol = 5;
        int nRow =8;
        int[][] buf = new int[nRow][nCol];
        for(int i=0; i< nRow; i++){
            for(int j=0; j< nCol; j++){
                buf[i][j] = random.nextInt(21)-10;
                System.out.print(buf[i][j] + "\t");
            }
            System.out.println();
        }
        int tmp =1;
        for(int i =0; i<nRow; i++){
            tmp=1;
            for(int j =0; j<nCol; j++){
                tmp*=buf[i][j];
            }
            if(Math.abs(maxMult) < Math.abs(tmp)){
                maxMult = tmp;
                maxIndex = i;
            }
        }
        System.out.println( maxIndex+" is row index with max");
        System.out.println();
    }
    static void taskD(){
        System.out.println("Task d.");
        Random random = new Random();
        int nRow = 10;
        int nCol = 7;
        int[][] buf = new int[nRow][nCol];
        for(int i=0; i<nRow; i++){
            for(int j =0; j<nCol; j++){
                buf[i][j] = random.nextInt(101);
                System.out.print(buf[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Sorted array");
        for(int i=0; i<nRow;  i++){
            Arrays.sort(buf[i]);
            int k=nCol -1;
            int j=0;
            int tmp;
            while(k>j){
                tmp = buf[i][j];
                buf[i][j] = buf[i][k];
                buf[i][k] = tmp;
                k--;
                j++;
            }
            for(j=0; j<nCol; j++){
                System.out.print(buf[i][j]+ "\t");
            }
            System.out.println();
        }
    }
}
