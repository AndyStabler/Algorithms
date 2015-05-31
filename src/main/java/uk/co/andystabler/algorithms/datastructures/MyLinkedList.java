package uk.co.andystabler.algorithms.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Andy Stabler on 30/05/15.
 */
public class MyLinkedList<T> implements MyList<T> {

    private Node head;

    /**
     * Adds an element to the beginning of the list (use append to add to the end of the list)
     *
     * @param data the data to add
     */
    @Override
    public void add(T data) {
        Node newData = new Node();
        newData.next = head;
        newData.value = data;
        head = newData;
    }

    /**
     * Removes the first occurrence of the found value from the linked list
     *
     * @param data the data to remove
     * @return whether the node was successfully removed from the list
     */
    @Override
    public boolean remove(T data) {

        // same as size == 0, but we don't need to iterate over the entire list using the null check on head
        if (head == null) return false;

        // data is first in list - swap head
        if (data.equals(head.value)) {
            head = head.next;
            return true;
        }

        // only 1 element in list, and it wasn't equal to the data to remove
        if (head.next == null) return false;

        // iterate through the list until we find the node
        MyListIterator iter = iter();

        // set current to head
        Node current = iter.next();

        while (iter.hasNext()) {
            Node prev = current;
            // current moves to one position ahead of head
            current = iter.next();
            // found the node
            // unlink it and return
            if (data.equals(current.value)) {
                prev.next = current.next;
                return true;
            }
        }
        // didn't find the data
        return false;
    }

    /**
     * Removes the elemenat at the given index, and returns its value
     *
     * @param pos the index to remove the data from
     * @return the value of the element removed
     */
    @Override
    public T remove(int pos) {
        int size = size();
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();

        if (head == null) throw new NoSuchElementException("List is empty");

        // if first, then reset head
        if (pos == 0) {
            T data = head.value;
            head = head.next;
            return data;
        }

        MyListIterator iter = iter();
        // set current to head
        Node current = iter.next();

        int i = 1;
        while (iter.hasNext()) {
            Node prev = current;
            current = current.next;
            if (i++ == pos) {
                prev.next = current.next;
                return current.value;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * @param data the dat to search for
     * @return true if the value exists in the list
     */
    @Override
    public boolean search(T data) {
        MyListIterator iter = iter();
        while (iter.hasNext())
            if (iter.next().value.equals(data)) return true;
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * @return the number of elements in the list
     */
    @Override
    public int size() {
        int count = 0;
        MyListIterator iter = iter();

        while (iter.hasNext()) {
            iter.next();
            count++;
        }

        return count;
    }

    /**
     * Adds an element to the end of the list
     *
     * @param data the data to append
     */
    @Override
    public void append(T data) {
        Node newNode = new Node();
        newNode.value = data;

        if (head == null) {
            head = newNode;
            return;
        }

        MyListIterator iter = iter();
        // set current to head
        Node current = head;
        while (iter.hasNext())
            current = iter.next();
        current.next = newNode;
    }

    /**
     * iterates through the list until a value equals the passed {@code data}.
     *
     * @param data the data to search for
     * @return the index the data was found at, or -1 if not found
     */
    @Override
    public int index(T data) {
        int index = 0;
        MyListIterator iter = iter();
        while (iter.hasNext()) {
            if (iter.next().value.equals(data)) return index;
            index++;
        }
        return -1;
    }

    /**
     * Inserts an element at the given index.
     * <p>
     * If the index is {@code 0}, the data becomes head, and points to the old head
     * <p>
     * If the index is {@code size of list}, the data is added to the end, with the old last element's next node pointing
     * to the new node
     * <p>
     * The index must be between 0...size of list, or an {@link IndexOutOfBoundsException} is thrown.
     *
     * @param index the index to add data
     * @param data  the data to add to the list
     */
    @Override
    public void insert(int index, T data) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException("Index must be in range 0...size of list");
        Node newNode = new Node();
        newNode.value = data;

        if (head == null) {
            head = newNode;
            return;
        }

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        MyListIterator iter = iter();
        // set currentNode to head
        Node currentNode = iter.next();

        int i = 1;
        while (iter.hasNext()) {
            Node prev = currentNode;
            currentNode = iter.next();
            if (index == i++) {
                prev.next = newNode;
                newNode.next = currentNode;
                return;
            }
        }
        // adding a node to the end of the list
        currentNode.next = newNode;
    }

    /**
     * Removes and returns the first element in the list
     * <p>
     * If the list is empty, a {@link NoSuchElementException}
     *
     * @return the first element in the list
     */
    @Override
    public T pop() {
        if (head == null) throw new NoSuchElementException("List is empty");

        T data = head.value;
        head = head.next;

        return data;
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
            return current != null;
        }

        @Override
        public Node next() {
            Node old = current;
            current = current.next;
            return old;
        }
    }

}
