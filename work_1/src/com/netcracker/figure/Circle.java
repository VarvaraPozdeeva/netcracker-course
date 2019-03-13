package com.netcracker.figure;

import java.util.Objects;

public class Circle {
    private double radius;
    private  String color;

    public Circle() {
        radius = 1.0;
        color = new String("red");
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 &&
                Objects.equals(color, circle.color);
    }

    @Override
    public int hashCode() {
        int hashcode =17;
        hashcode+= 31*hashcode + color.hashCode();
        long l = Double.doubleToLongBits(radius);
        hashcode += 31*hashcode + (int)(1^(l>>>32));
        return hashcode;
    }

    @Override
    public String toString() {
        return "Circle [ radius = " + radius +", color = " + color + "]";
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
}
