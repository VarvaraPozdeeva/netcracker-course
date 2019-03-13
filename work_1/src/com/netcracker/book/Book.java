package com.netcracker.book;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price) {
        this.name = name;
        this.authors = authors;
        this.price = price;
    }

    public Book(String name, Author[] authors, double price, int qty) {
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book[" +
                "name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", price=" + price +
                ", qty=" + qty +
                ']';
    }
    public String getAuthorNames(){
        String res = "";
        for(int i=0; i< authors.length; i++){
            if(i==authors.length-1)
                res+=authors[i].getName();
            else
                res += authors[i].getName()+", ";
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0 &&
                qty == book.qty &&
                Objects.equals(name, book.name) &&
                Arrays.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int hashcode = 17;
        hashcode+=31*hashcode + name.hashCode();
        for(Author a: authors) {
            hashcode += 31 * hashcode + a.hashCode();
        }

        long l = Double.doubleToLongBits(price);
        hashcode+= 31*hashcode + (int)(1^(l>>>32));
        hashcode+= 31*hashcode + qty;
        return hashcode;
    }
}
