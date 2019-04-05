package com.netcracker.perfomance;

import com.netcracker.mycollection.MyLinkedList;
import java.util.*;

public class TestPerformance {

    private static int n = 100_000;

    private static LinkedList<Integer> linkedList = new LinkedList<>();
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
    private  static HashSet<Integer> hashSet = new HashSet<>();
    private static LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
    private static TreeSet<Integer> treeSet = new TreeSet<>();
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static LinkedHashMap<Integer,Integer> linkedHashMap = new LinkedHashMap<>();
    private static TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    private static String line = "+---------------+---------------+---------------+---------------+";

    private  static  Random random = new Random();
    private  static Integer[] data = new Integer[n];

    public static void setN(int n) {
        TestPerformance.n = n;
    }
    public static void testList() {

        System.out.println("TEST LIST");
        System.out.println(line);
        System.out.format("|%15s|%15s|%15s|%15s|\n", "", "ArrayList", "LinkedList", "MyLinkedList");
        System.out.println(line);

        insertBeginList();
        insertMiddleList();
        insertEndList();
        addList();
        deleteBeginList();
        deleteMiddleList();
        deleteEndList();
    }
    public static void testSet(){
        System.out.println("TEST SET");
        System.out.println(line);
        System.out.format("|%15s|%15s|%15s|%15s|\n", "", "HashSet", "LinkedHashSet", "TreeSet");
        System.out.println(line);
        setData();
        addSet();
        containSet();
        deleteSet();
    }
    public static void testMap(){
        System.out.println("TEST MAP");
        System.out.println(line);
        System.out.format("|%15s|%15s|%15s|%15s|\n", "", "HashMap", "LinkedHashMap", "TreeMap");
        System.out.println(line);
        setData();
        addMap();
        getMap();
        deleteMap();
    }

    private static void getMap() {
        if(hashMap.size()==0){
            hashMap.clear();
            linkedHashMap.clear();
            treeMap.clear();
        }
        System.out.format("|%15s|","Get");

        getMap(hashMap);
        getMap(linkedHashMap);
        getMap(treeMap);

        System.out.println();
        System.out.println(line);
    }
    private static void getMap(Map<Integer, Integer> map){
        long finisTime;
        long startTime = System.nanoTime();
        for(int i=0; i<n; i++){
            map.get(data[random.nextInt(map.size()-1)]);
        }
        finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }
    private static void deleteMap(Map<Integer, Integer> map){
        long finisTime;
        long startTime = System.nanoTime();
        for(int i=0; i<n; i++){
            map.remove(data[random.nextInt(map.size()-1)]);
        }
        finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }
    private static void deleteMap() {

        System.out.format("|%15s|","Delete");
        deleteMap(hashMap);
        deleteMap(linkedHashMap);
        deleteMap(treeMap);

        System.out.println();
        System.out.println(line);
    }
    private static void addMap() {

        if(hashMap.size()!=0){
            hashMap.clear();
            linkedHashMap.clear();
            treeMap.clear();
        }
        System.out.format("|%15s|","Add");
        addMap(hashMap);
        addMap(linkedHashMap);
        addMap(treeMap);

        System.out.println();
        System.out.println(line);

    }
    private static void addMap(Map<Integer, Integer> map){
        long finisTime;
        long startTime = System.nanoTime();
        for(int i=0; i<n; i++){
            map.put(data[i], i);
        }
        finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }

    private static void containSet() {
        System.out.format("|%15s|","Contains");
        containSet(hashSet);
        containSet(linkedHashSet);
        containSet(treeSet);
        System.out.println();
        System.out.println(line);
    }
    private static void containSet(Set<Integer> c ){
        if(c.size() ==0){
            addDataSet(c);
        }
        long startTime = System.nanoTime();
        for(int i=0; i<n; i++){
            c.contains(data[random.nextInt(c.size()-1)]);
        }
        long finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }
    private static void deleteSet() {

        System.out.format("|%15s|","Delete ");
        deleteSet(hashSet);
        deleteSet(linkedHashSet);
        deleteSet(treeSet);
        System.out.println();
        System.out.println(line);
    }
    private static void deleteSet(Set<Integer> c ){
        if(c.size() ==0){
            addDataSet(c);
        }
        long startTime = System.nanoTime();
        for(int i=0; i<n; i++){
            c.remove(data[random.nextInt(c.size()-1)]);
        }
        long finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }
    private static void addDataSet(Set<Integer> set) {
        for(int i=0; i<n; i++){
            set.add(data[i]);
        }
    }
    private static void addSet() {

        System.out.format("|%15s|","Add");
        addSet(hashSet);
        addSet(linkedHashSet);
        addSet(treeSet);
        System.out.println();
        System.out.println(line);
    }
    private static void addSet(Set<Integer> c){
        if(c.size()!=0){
            c.clear();
        }
        long startTime = System.nanoTime();
        for(int i=0; i<n; i++){
            c.add(data[i]);
        }
        long finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }
    private static void setData(){
        for(int i =0; i<n; i++){
            data[i] = random.nextInt(1_000_000_000);
        }
    }

    private static void addList() {

        System.out.format("|%15s|", "Add");

        addList(arrayList, -1 );
        addList(linkedList, -1);
        addList(myLinkedList, -1);

        System.out.println();
        System.out.println(line);
    }
    private static void insertEndList() {

        System.out.format("|%15s|", "Insert end");

        addList(arrayList, 1);
        addList(linkedList, 1);
        addList(myLinkedList, 1);

        System.out.println();
        System.out.println(line);
    }
    private static void insertMiddleList() {

        System.out.format("|%15s|", "Insert middle");

        addList(arrayList, 2);
        addList(linkedList, 2);
        addList(myLinkedList, 2);

        System.out.println();
        System.out.println(line);
    }
    private static void insertBeginList(){

        System.out.format("|%15s|","Insert begin");

        addList(arrayList, 0);
        addList(linkedList, 0);
        addList(myLinkedList, 0);

        System.out.println();
        System.out.println(line);
    }
    private static void addList(List<Integer> list, int position) {

        long startTime = System.nanoTime();
        switch (position) {
            case 0:
                for (int i = 0; i < n; i++) {
                    list.add(0, random.nextInt(1000));
                }
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    list.add(list.size(), random.nextInt(1000));
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    list.add((list.size()-1)/2, random.nextInt(1000));
                }
                break;
            case -1:
                for (int i = 0; i < n; i++) {
                    list.add( random.nextInt(1000));
                }
                break;
        }
        long finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
        list.clear();
    }
    private static void addList(MyLinkedList<Integer> list, int position) {

        long startTime = System.nanoTime();
        switch (position) {
            case -1:
                for (int i = 0; i < n; i++) {
                    list.add( random.nextInt(1000));
                }
                break;
            case 0:
                for (int i = 0; i < n; i++) {
                    list.add(0, random.nextInt(1000));
                }
                break;
            case 1:
                for (int i = 0; i < n; i++) {
                    list.add(list.size(), random.nextInt(1000));
                }
                break;
            case 2:
                for (int i = 0; i < n; i++) {
                    list.add((list.size()-1)/2, random.nextInt(1000));
                }
                break;

        }
        long finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
        list.clear();
    }
    private static void deleteEndList() {

        System.out.format("|%15s|","Delete end");

        deleteList(arrayList, 1);
        deleteList(linkedList, 1);
        deleteList(myLinkedList, 1);

        System.out.println();
        System.out.println(line);
    }
    private static void deleteMiddleList() {

        System.out.format("|%15s|","Delete middle");

        deleteList(arrayList, 2);
        deleteList(linkedList, 2);
        deleteList(myLinkedList, 2);

        System.out.println();
        System.out.println(line);

    }
    private static void deleteBeginList() {

        System.out.format("|%15s|","Delete begin");

        deleteList(arrayList, 0);
        deleteList(linkedList, 0);
        deleteList(myLinkedList, 0);

        System.out.println();
        System.out.println(line);
    }
    private static void addData(Collection<Integer> c){
        for(int i=0; i<n; i++){
            c.add(random.nextInt(100000));
        }
    }
    private static void addData(MyLinkedList<Integer> c){
        for(int i=0; i<n; i++){
            c.add(random.nextInt(100000));
        }
    }
    private static void deleteList(List<Integer> list, int position) {

        addData(list);

        long startTime = System.nanoTime();
        switch (position){
            case 0:
                for(int i=0; i<n; i++){
                    list.remove(0);
                }
                break;
            case 1:
                for(int i=0; i<n; i++){
                    list.remove(list.size()-1);
                }
                break;
            case 2:
                for(int i=0; i<n; i++){
                    list.remove(list.size()/2);
                }
                break;
        }
        long finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }
    private static void deleteList(MyLinkedList<Integer> list, int position) {

        addData(list);

        long startTime = System.nanoTime();
        switch (position){
            case 0:
                for(int i=0; i<n; i++){
                    list.remove(0);
                }
                break;
            case 1:
                for(int i=0; i<n; i++){
                    list.remove(list.size()-1);
                }
                break;
            case 2:
                for(int i=0; i<n; i++){
                    list.remove(list.size()/2);
                }
                break;
        }
        long finisTime = System.nanoTime();
        double time =(double) (finisTime - startTime)/1000000;
        System.out.format("%15s|",Double.toString(time) );
    }

}
