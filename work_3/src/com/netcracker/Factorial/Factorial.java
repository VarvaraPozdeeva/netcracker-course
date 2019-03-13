package com.netcracker.Factorial;

public class Factorial {

    public static void main(String[] args) {

        long start;
        long finish;
        int n = 25;
        start = System.nanoTime();
        long result = loopFactor(n);
        finish = System.nanoTime() - start;
        System.out.println("Time of loop calculation = "+ finish+  " ns");
        start = System.nanoTime();
        result = recFactor(n);
        finish = System.nanoTime() - start ;
        System.out.println("Time of recursion calculation = "+ finish +  " ns");
        System.out.println(n+"! = "+ result);
    }
    static long loopFactor(int n){
        long res=1;
        for(int i=1; i<=n; i++) {
            res *= i;
        }
        return res;
    }
    static long recFactor(int n){
        long res =0;
        if(n == 1) {
        return 1;
        }
        return recFactor(n-1)*n;
    }

}
