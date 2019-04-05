package com.netcracker.mycollection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class MyLinkedList<E> implements ILinkedList<E> {

    private int size=0;
    private Node<E> first;
    private Node<E> last;

    public MyLinkedList(){
        first = last = null;
    }

    private void addBefore(E element, Node<E> node){

        Node<E> newNode = new Node<>(element, node.prev, node);
        if(node.prev == null){
            first = newNode;
        }
        else {
            node.prev.next = newNode;
        }
        node.prev = newNode;
        size++;
    }
    private void addLast(E element){

        Node<E> newNode = new Node<>(element, last, null);
        if(last == null){
            first = newNode;
        }
        else{
            last.next = newNode;
        }
        last = newNode;
        size++;
    }
    private void addFirst(E element){

        Node<E> newNode = new Node<>(element, null, first);
        if(first == null){
            last = newNode;
        }
        else{
            first.prev = newNode;
        }
        first = newNode;
        size++;
    }
    private void checkIndexForAdd(int index){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index = " + index + ", size = " + size);
        }
    }
    private void checkIndex(int index){
        if(index < 0 || index >=size){
            throw new IndexOutOfBoundsException("Index = " + index + ", size = " + size);
        }
    }
    private Node<E> nodeByIndex(int index){

        Node<E> node;
        if( index < size/2 ) {
            node = first;
            for(int i=0; i<index; i++){
                node = node.next;
            }
        }
        else {
            node = last;
            for(int i= size -1; i>index; i--){
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public void add(E element) {

        addLast(element);
    }

    @Override
    public void add(int index, E element) {

        checkIndexForAdd(index);
        if(index == size){
            addLast(element);
        }
        else if(index == 0){
            addFirst(element);
        }
        else{
            addBefore(element, nodeByIndex(index));
        }
    }

    @Override
    public void clear() {

        if(size>0){
            for(Node<E> node = first; node!=null; )
            {
                Node<E> n = node;
                node = node.next;
                n.prev = null;
                n.next = null;
                n.element = null;
            }
            first=last=null;
            size=0;
        }
    }
    @Override
    public E get(int index) {

        checkIndex(index);
        return nodeByIndex(index).element;
    }

    @Override
    public int indexOf(E element) {
        int index =0;
        if(element == null){
            for(Node<E> node = first; node!= null ; node = node.next,index++){
                if(node.element == null){
                    return index;
                }
            }
        }
        else {
            for(Node<E> node = first; node!= null ; node = node.next,index++){
                if(node.element.equals(element)){
                    return index;
                }
            }
        }
        return  -1;
    }

    @Override
    public E remove(int index) {

        checkIndex(index);
        return unlink(nodeByIndex(index));
    }
    private E unlink(Node<E> node){

        E element = node.element;
        if(node.prev == null){
            first = node.next;
        }
        else {
            node.prev.next = node.next;
        }
        if(node.next == null){
            last=node.prev ;
        }
        else {
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
        node.element = null;
        size--;
        return  element;
    }

    @Override
    public E set(int index, E element) {

        checkIndex(index);
        Node<E> node = nodeByIndex(index);
        E oldElem = node.element;
        node.element = element;
        return oldElem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray() {
        if(first == null ){
            return null;
        }
        E[] array = (E[]) java.lang.reflect.Array.newInstance(first.element.getClass(), size);
        int i=0;
        for(Node<E> node = first; node != null; i++, node = node.next){
            array[i] = node.element;
        }
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> lastReturn = null;
            private Node<E> next = first;
            private int nextIndex = 0;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {

                if (!(hasNext())) {
                    throw new NoSuchElementException();
                }
                lastReturn = next;
                next = next.next;
                nextIndex++;
                return lastReturn.element;
            }

            @Override
            public void remove() {

                if (lastReturn == null) {
                    throw new IllegalStateException();
                }
                unlink(lastReturn);
                lastReturn = null;
                nextIndex--;
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {

                Objects.requireNonNull(action);
                while (hasNext()) {
                    action.accept(next.element);
                    lastReturn = next;
                    next = next.next;
                    nextIndex++;
                }
            }
        };
    }


    @Override
    public String toString() {

        String result = "[";
        if(first!=null) {
            result += first.element;
            for (Node<E> node = first.next; node != null; node = node.next) {

                result += ", " + node.element;
            }
        }
        result += "]";
        return result;
    }

    private static class Node<E>{

        E element;
        Node<E> next;
        Node<E> prev;

        Node(E e, Node<E> prev, Node<E> next ){

            element =e;
            this.next =next;
            this.prev = prev;
        }
    }
}