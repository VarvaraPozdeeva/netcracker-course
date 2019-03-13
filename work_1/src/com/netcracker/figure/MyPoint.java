package com.netcracker.figure;

import java.util.Objects;

public class MyPoint {
    private int x;
    private int y;

    public MyPoint() {
        x=0;
        y=0;
    }

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyPoint myPoint = (MyPoint) o;
        return x == myPoint.x &&
                y == myPoint.y;
    }

    @Override
    public int hashCode() {
        int hashcode =17;
        hashcode += 31*hashcode + x;
        hashcode +=31*hashcode +y;
        return hashcode;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ')';
    }
    public int[] getXY(){
        int res[] = new int[2];
        res[0]=x;
        res[1] = y;
        return res;
    }

    public double distance(int x, int y){
        double res;
        res = Math.sqrt((this.x - x)*(this.x - x) + (this.y-y)*(this.y - y));
        return res;
    }
    public double distance(MyPoint another) {
        double res;
        res = Math.sqrt((this.x - another.getX())*(this.x - another.getX()) + (this.y-another.getY())*(this.y - another.getY()));
        return res;
    }
    public double distance(){
        double res;
        res = Math.sqrt((x*x + y*y));
        return res;
    }
}
