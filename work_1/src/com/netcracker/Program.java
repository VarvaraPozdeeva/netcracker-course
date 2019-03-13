package com.netcracker;

import com.netcracker.Employee.Employee;
import com.netcracker.book.*;
import com.netcracker.figure.*;


public class Program {
    public static void main(String[] args) {
        Author authors[] = new Author[3];
        authors[1] = new Author("Pavel", "aaa", 'm');
        authors[2] = new Author("Ivan", "aaa", 'm');
        authors[0] = new Author("Vera", "aaa", 'f');
        Book book = new Book("first", authors, 100.0);
        System.out.println("Book name is = " + book.getName() + ", book price is " + book.getPrice());
        System.out.println("Autors " + book.getAuthorNames());
        System.out.println(book);
        System.out.println();

        Circle c = new Circle(2.3, "red");
        System.out.println(c + " area = " + c.getArea());
        System.out.println();

        Rectangle r = new Rectangle(100, 20);
        System.out.println(r+ " area = " + r.getArea() + " perimetr = " + r.getPerimeter());
        System.out.println();

        Employee e = new Employee(1,"Ivan", "Ivanov", 100);
        System.out.println(e + " AnnualSalary = " + e.getAnnualSalary() + " raiseSalary(10) = " + e.raiseSalary(10));
        System.out.println();

        MyPoint p = new MyPoint(3, 4);
        System.out.println(p +" distance from (0,0) = " + p.distance() + " distanse to (3,2) = " + p.distance(p));
        System.out.println();

        MyTriangle t = new MyTriangle(0,0,1,1,1,0);
        System.out.println(t + " triangle is " + t.getType() + ", perimetr = " + t.getPerimetr());
        System.out.println();
    }
}
