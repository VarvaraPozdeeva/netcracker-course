package work_2.com.netcracker.myComplex;

import java.net.DatagramPacket;
import java.util.Objects;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {
        real = 0.0;
        imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real + "+" + imag +"i)";
    }
    public boolean isReal(){
        return real != 0;

    }
    public boolean isImaginary(){
        return imag != 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        MyComplex myComplex = (MyComplex) o;
        return Double.compare(myComplex.real, real) == 0 &&
                Double.compare(myComplex.imag, imag) == 0;
    }

    @Override
    public int hashCode() {
        int hashcode =17;
        long l;
        l = Double.doubleToLongBits(real);
        hashcode += 31*hashcode + (int)(1^(l>>>32));
        l = Double.doubleToLongBits(imag);
        hashcode += 31*hashcode + (int)(1^(l>>>32));
        return hashcode;
    }

    public boolean equals(double real, double imag){
        return this.real == real && this.imag == imag;
    }
    public double magnitude(){
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument(){
        return Math.atan(imag/real);
    }
    public MyComplex add(MyComplex right){
        real += right.getReal();
        imag +=right.getImag();
        return this;
    }
    public MyComplex addNew(MyComplex right){
        MyComplex res  = new MyComplex(real + right.getReal(), imag + right.getImag());
        return res;
    }

    public MyComplex subtract(MyComplex right){
        real-= right.getReal();
        imag -= right.getImag();
        return this;
    }
    public MyComplex subtractNew(MyComplex right){
        MyComplex res = new MyComplex(real - right.getReal(), imag - right.getImag());
        return res;
    }
    public MyComplex multiply(MyComplex right){
        real = (real*right.getReal() - imag*right.getImag());
        imag = (real*right.getImag()+ imag*right.getReal());
        return this;
    }
    public  MyComplex divide( MyComplex right){
        real = (real*right.getReal() + imag*right.getImag() )/
               (right.getReal()*right.getReal() + right.getImag()*right.getImag());
        imag = (right.getReal()*imag - real*right.getImag()) /
               (right.getReal()*right.getReal() + right.getImag()*right.getImag());
        return this;
    }

    public MyComplex conjugate(){
        MyComplex res = new MyComplex(real, imag*(-1));
        return  res;
    }


}
