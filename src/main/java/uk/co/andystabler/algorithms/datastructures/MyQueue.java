package uk.co.andystabler.algorithms.datastructures;

/**
 * Created by Andy Stabler on 01/06/15.
 */
public interface MyQueue<T> {

    boolean isEmpty();

    T peek();

    void offer(T data);

    T poll();

    int size();
}
