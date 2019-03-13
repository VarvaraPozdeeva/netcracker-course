package com.netcracker.Sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void main(String[] args) {
        int n = 10000;
        int[] buf = new int[n];
        int tmp1[] = new int[n];
        int tmp2[] = new int[n];

        Random random = new Random();
        for(int i =0; i< buf.length; i++){
            buf[i] = random.nextInt(100);
            tmp1[i] = buf[i];
            tmp2 [i] = buf[i];
        }
        System.out.println("Array size = " + n);

        long startTime =  System.nanoTime();
        Arrays.sort(buf);
        double finishTime = finishTime = (double)(System.nanoTime() - startTime)/1000000000.0;
        System.out.println("Time of Arrays.sort = " + finishTime + " s");
        System.out.println("Time of bubleSort = " + bubleSort(tmp1) + " s");
        System.out.println("Time of selectSort = " + selectSort(tmp2) + " s");
    }
    public static double bubleSort(int[] a){
       long startTime = System.nanoTime();
        int flag =0;
        int tmp =0;
        for(int i=0; i< a.length-1; i++){
            flag =0;
            for ( int j=0; j< a.length - i-1; j++){
                if(a[j] >a[j+1]){
                    tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag =1;
                }
            }
            if(flag == 0) break;
        }
        return (double)(System.nanoTime() - startTime)/1000000000.0;
    }

    public static double selectSort(int[] a) {
        long startTime = System.nanoTime();
        int min;
        int tmp =0;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if(i!= min) {
                tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
        return  (double)(System.nanoTime() - startTime)/1000000000.0;
    }
}
