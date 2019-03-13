package com.netcracker.Loop;

public class Loop {
    public static void main(String[] args) {
        int size = 5 ;
        for(int row =0; row<size; row++){
            for(int col =0; col<size; col++){
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();

        size =8;

        for(int row =0; row<size; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
        for(int row =0; row<size; row++) {
            for (int col = 0; col < size - row; col++) {
                System.out.print("# ");
            }
            System.out.println();
        }
        System.out.println();
        for(int row =0; row<size; row++) {
            for (int col = 0; col < size; col++) {
                if(col >= size-1 - row)
                    System.out.print("# ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();

        size =7;

        for(int row =0; row<size; row++) {
            if(row == 0 || row == size-1) {
                for (int col = 0; col < size; col++) {
                    System.out.print("# ");
                }
                System.out.println();
            }
            else{
                for (int col = 0; col < size; col++){
                    if(col == row){
                        System.out.print("# ");
                    }
                    else System.out.print("  ");
                }
                System.out.println();
            }
        }
        System.out.println();
        for(int row =0; row<size; row++) {
            if(row == 0 || row == size-1) {
                for (int col = 0; col < size; col++) {
                    System.out.print("# ");
                }
                System.out.println();
            }
            else{
                for (int col = 0; col < size; col++){
                    if(col == size-1 - row || col == row || col == 0 || col == size-1){
                        System.out.print("# ");
                    }
                    else System.out.print("  ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
