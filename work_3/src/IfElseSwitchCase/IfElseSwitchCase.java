package IfElseSwitchCase;

import java.util.Random;

public class IfElseSwitchCase {
    public static void main(String[] args) {
        Week[] day = new Week[5];
        day[0] = Week.MONDAY;
        day[1] = Week.TUESDAY;
        day[2] = Week.WEDNESDAY;
        day[3] = Week.THURSDAY;
        day[4] = Week.FRIDAY;
        long start = System.nanoTime();
        for(int i =0; i< 5; i++) {
            if (day[i] == Week.FRIDAY)
                System.out.println("It is FRIDAY");
            else if (day[i] == Week.MONDAY)
                System.out.println("It is MONDAY");
            else if (day[i] == Week.THURSDAY)
                System.out.println("It is THURSDAY");
            else if (day[i] == Week.TUESDAY)
                System.out.println("It is TUESDAY");
            else if (day[i] == Week.WEDNESDAY)
                System.out.println("It is WEDNESDAY");
        }
        long finish = System.nanoTime() - start;
        System.out.println(finish);

        start = System.nanoTime();
        for(int i=0; i< 5; i++) {
            switch (day[i]) {
                case FRIDAY: {System.out.println("It is FRIDAY"); break;}
                case MONDAY: {System.out.println("It is MONDAY"); break;}
                case TUESDAY: {System.out.println("It is TUESDAY"); break;}
                case THURSDAY: {System.out.println("It is THURSDAY"); break;}
                case WEDNESDAY: {System.out.println("It is WEDNESDAY"); break;}
            }
        }
        finish = System.nanoTime() - start;
        System.out.println(finish);
        System.out.println();


        int n=50;
        int[] buf = new int[n];
        int[] count = new int[11];
        Random rand = new Random();
        for(int i=0; i<n; i++){
            buf[i] = rand.nextInt(11);
            System.out.print(buf[i]+" ");
        }
        System.out.println();
        start = System.nanoTime();
        for(int i=0; i<n; i++){
            if(buf[i] == 0)
               count[0]++;
            else if(buf[i] == 1)
               count[1]++;
            else if(buf[i] == 2)
               count[2]++;
            else if(buf[i] == 3)
               count[3]++;
            else if(buf[i] == 4)
                count[4]++;
            else if(buf[i] == 5)
                count[5]++;
            else if(buf[i] == 6)
                count[6]++;
            else if(buf[i] == 7)
                count[7]++;
            else if(buf[i] == 8)
                count[8]++;
            else if(buf[i] == 9)
                count[9]++;
            else if(buf[i] == 10)
                count[10]++;
        }
        finish = System.nanoTime() - start;
        System.out.println(finish);
        for(int i=0; i< 11; i++) {
            System.out.println("Element "+i+" passed " + count[i] + " branch");
        }
        for(int i=0; i< 11; i++){
            count[i] =0;
        }

        start = System.nanoTime();
        for(int i =0; i< n; i++){
            switch (buf[i]){
                case 0:{ count[0]++; break;}
                case 1:{ count[1]++; break;}
                case 2:{ count[2]++; break;}
                case 3:{ count[3]++; break;}
                case 4:{ count[4]++; break;}
                case 5:{ count[5]++; break;}
                case 6:{ count[6]++; break;}
                case 7:{ count[7]++; break;}
                case 8:{ count[8]++; break;}
                case 9:{ count[9]++; break;}
                case 10:{ count[10]++; break;}
            }
        }
        finish = System.nanoTime() - start;
        System.out.println(finish);

        for(int i=0; i< 11; i++) {
            System.out.println("Element "+i+" passed " + count[i] + " branch");
        }
    }
}

