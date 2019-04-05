package com.netcracker.mycollection;

import java.util.Iterator;

public class MyClass {
    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("one");
        myLinkedList.add("three");
        myLinkedList.add("four");
        myLinkedList.add("five");

        System.out.println("MyList --> " + myLinkedList.toString() );
        System.out.println("Size --> " + myLinkedList.size());

        myLinkedList.add(1, "two");
        System.out.print("After insert on 2 position --> " );
        System.out.println(myLinkedList.toString());
        System.out.println("Get element by index 3 --> " + myLinkedList.get(3));

        System.out.print("Print using iterator --> ");
        Iterator iter = myLinkedList.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next()+ " ");
        }
        System.out.println();

        String s = myLinkedList.remove(3);
        System.out.println("Remove element with index 3 --> " + myLinkedList.toString());

        s = myLinkedList.set(3,"four");
        System.out.println("Set element with index 3 --> " + myLinkedList.toString());
        System.out.println("Get index of \"three\" --> " + myLinkedList.indexOf("three"));

        String[] str = myLinkedList.toArray();
        System.out.print("to Array -->  ");
        for(String st: str){
            System.out.print(st + " ");
        }
        System.out.println();

        myLinkedList.clear();
        System.out.println("MyList after clear() --> " + myLinkedList.toString());
    }
}
