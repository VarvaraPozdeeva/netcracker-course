package com.netcracker.figure;

import java.util.Objects;

public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(MyPoint v1, MyPoint v2, MyPoint v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }
    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        v1 = new MyPoint(x1,y1);
        v2 = new MyPoint(x2,y2);
        v3 = new MyPoint(x3,y3);
    }

    @Override
    public String toString() {
        return "MyTriangle{" +
                "v1=" + v1.toString() +
                ", v2=" + v2.toString() +
                ", v3=" + v3.toString() +
                '}';
    }
    public double getPerimetr(){
        double a1,a2,a3;
        a1= v1.distance(v2);
        a2 = v2.distance(v3);
        a3 = v3.distance(v1);

        return a1+a2+a3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        MyTriangle that = (MyTriangle) o;
        return Objects.equals(v1, that.v1) &&
                Objects.equals(v2, that.v2) &&
                Objects.equals(v3, that.v3);
    }

    @Override
    public int hashCode() {
        int hashcode =17;
        hashcode += 31*hashcode + v1.hashCode();
        hashcode += 31*hashcode + v2.hashCode();
        hashcode += 31*hashcode + v3.hashCode();
        return hashcode;
    }

    public String getType(){
        String res;
        if(Double.compare(v1.distance(v2) ,v3.distance(v1)) == 0 && Double.compare(v2.distance(v3),  v3.distance(v1)) == 0)
            res = "Equilateral";
        else if( Double.compare(v1.distance(v2), v2.distance(v3))==0 || Double.compare(v3.distance(v1), v2.distance(v3))==0 || Double.compare(v1.distance(v2), v1.distance(v3))==0 )
            res = "Isosceles";
        else
            res = "Scalene";
        return res;
    }
}
