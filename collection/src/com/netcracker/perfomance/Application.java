package com.netcracker.perfomance;

public class Application {
    public static void main(String[] args) {
        TestPerformance.setN(10000);
        TestPerformance.testList();
        TestPerformance.testSet();
        TestPerformance.testMap();
    }
}

