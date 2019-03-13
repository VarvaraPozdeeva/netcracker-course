package com.netcracker.ArrayTask;

import java.util.Arrays;
import java.util.Random;

public class ArrayTask {
    public static void main(String[] args) {
        taskA();
        taskB();
        taskC();
        taskD();
        taskE();
        taskF();
    }
    static void taskA(){
        System.out.println("Task a.");
        int n =50;
        int[] buf = new int[n];
        for (int i = 0; i < n; i++) {
            buf[i] = (i * 2 + 1);
        }
        for(int i=0; i<n; i++){
            System.out.print(buf[i]+" ");
        }
        System.out.println();
        for(int i =n-1; i>=0; i--){
            System.out.print(buf[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
    static void taskB(){
        System.out.println("Task b.");
        Random random = new Random();
        int n=20;
        int[] buf = new int[n];
        int even =0;
        int uneven =0;
        for(int i=0; i<n; i++){
            buf[i] = random.nextInt(11);
            if(buf[i]%2 == 1)
                uneven++;
            else
                even++;
        }
        System.out.println(Arrays.toString(buf));
        System.out.println("Even = "+ even + ", Uneven = "+ uneven);
        System.out.println();
    }
    static void taskC(){
        System.out.println("Task c.");
        Random random = new Random();
        int n=10;
        int[] buf = new int[n];
        for(int i=0; i<n; i++){
            buf[i] = random.nextInt(100)+1;
        }
        System.out.println(Arrays.toString(buf));
        for(int i=1; i<n; i+=2){
            buf[i] =0;
        }
        System.out.println(Arrays.toString(buf));
        System.out.println();
    }
    static void taskD(){
        System.out.println("Task d.");
        Random random = new Random();
        int n=15;
        int[] buf = new int[n];
        for(int i=0; i<n; i++){
            buf[i] = random.nextInt(101) - 50;
        }
        int indMax=0;
        int indMin=0;
        for(int i=0; i<n; i++){
            if(buf[indMax] <=buf[i]){
                indMax = i;
            }
            if(buf[indMin]  >=  buf[i]){
                indMin = i;
            }
        }
        System.out.println(Arrays.toString(buf));
        System.out.println("max = "+buf[indMax]+" index = "+ indMax);
        System.out.println("min = "+buf[indMin] + " index = " + indMin);
        System.out.println();
    }
    static void taskE(){
        System.out.println("Task e.");
        Random random = new Random();
        int n=10;
        int[] buf1 = new int[n];
        int[] buf2 = new int[n];
        int sum1=0;
        int sum2=0;
        for(int i=0; i<n; i++){
            buf1[i] = random.nextInt(11);
            sum1+= buf1[i];
            buf2[i] = random.nextInt(11);
            sum2+= buf2[i];
        }
        System.out.println(Arrays.toString(buf1));
        System.out.println(Arrays.toString(buf2));
        sum1 /=n;
        sum2 /=n;
        System.out.println("Average of first = "+ sum1+", average of second = "+sum2);
        if(sum1>sum2)
            System.out.println("Average of first is greater. ");
        else if(sum1 == sum2)
            System.out.println("Averages are equal " );
        else
            System.out.println("Average of second is greater " );
        System.out.println();

    }
    static void taskF(){
        System.out.println("Task f.");
        Random random = new Random();
        int n=20;
        int[] buf= new int[n];
        int count0=0;
        int count1=0;
        int count=0;
        for(int i =0; i< n; i++){
            buf[i] = random.nextInt(3) -1;
            if(buf[i] == 1 ) count1++;
            else if(buf[i] == 0 ) count0++;
            else count++;
        }
        System.out.println(Arrays.toString(buf));
        System.out.println("Count -1 = "+count+", count 0 = "+count0 + ", count 1 = " + count1);
        int countMax = Math.max(Math.max(count, count0), count1);
        System.out.print("The most frequent elements = ");
        if(count == countMax)
            System.out.print("-1 ");
        if(count0 == countMax)
            System.out.print("0 ");
        if(count1 == countMax)
            System.out.print("1 ");
        System.out.println();
    }
}
