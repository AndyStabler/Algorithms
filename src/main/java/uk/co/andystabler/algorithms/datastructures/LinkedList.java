package uk.co.andystabler.algorithms.datastructures;

import java.util.Iterator;

/**
 * Created by Andy Stabler on 30/05/15.
 */
public class LinkedList<T> implements MyList<T> {

    private Node head;

    @Override
    public void add(T data) {
        Node newData = new Node();
        newData.next = head;
        head = newData;
    }

    @Override
    public boolean remove(T data) {

        // data is first in list - swap head
        if (data.equals(head.value)) {
            Node newData = new Node();
            newData.next = head.next;
            head = newData;
            return true;
        }

        // only 2 elements?
        if (size() < 2) return head.next.equals(data);

        // iterate through the list until we find the node
        MyListIterator iter = iter();

        Node prev = head;
        Node current = iter.next();

        while (iter.hasNext()) {
            Node next = iter.next();
            // found the node
            // unlink it and return
            if (data.equals(current)) {
                prev.next = next;
                return true;
            }
        }
        // didn't find the data
        return false;
    }

    @Override
    public boolean search(T data) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void append(T data) {

    }

    @Override
    public int index(T data) {
        return 0;
    }

    @Override
    public void insert(int index, T data) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T pop(int pos) {
        return null;
    }

    public MyListIterator iter() {
        return new MyListIterator();
    }

    private class Node {
        Node next;
        T value;
    }

    private class MyListIterator implements Iterator<Node> {

        Node current;

        public MyListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public Node next() {
            Node old = current;
            current = current.next;
            return old;
        }
    }

}
