package work_2.com.netcracker;

import work_2.com.netcracker.Ball.Ball;
import work_2.com.netcracker.Ball.Container;
import work_2.com.netcracker.myPolynomial.MyPolynomial;
import work_2.com.netcracker.myComplex.MyComplex;

public class Program {
    public static void main(String[] args) {
        Ball ball = new Ball(2,10,1,1, 45);
        Container container = new Container(2,2,10,10);

        while( !container.collides(ball)) {
            ball.move();
        }
        System.out.println("Ball in container");
        System.out.println(ball);
        System.out.println(container);
        System.out.println();

        double cof[] = {3.6, 96.3, 4.2};
        MyPolynomial pol = new MyPolynomial(cof);
        System.out.println("Polimom #1 = " + pol);
        double cof2[] = {1, 1, 1, 1};
        MyPolynomial pol2 = new MyPolynomial(cof2);
        System.out.println("Polinom #2 = " + pol2);
        System.out.println("#1 + #2 = " + pol.add(pol2));
        System.out.println("#1 * #2 = " + pol.multiply(pol2));
        System.out.println();

        MyComplex complex = new MyComplex(1, 1);
        MyComplex complex1 = new MyComplex(2,2 );
        MyComplex complex2 = new MyComplex(3,3 );

        System.out.println("Num #1 = " + complex + " num #2 = " + complex1  + " num #3 = "+ complex2);
        System.out.println("#2 += #1 --> "+complex1.add(complex));
        System.out.println(complex1 +"==" + complex2 + "-->"+ complex1.equals(complex2));
        System.out.println("#3/#1 = "+ complex2.divide(complex));
    }
}
