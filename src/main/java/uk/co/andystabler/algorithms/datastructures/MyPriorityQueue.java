package uk.co.andystabler.algorithms.datastructures;

/**
 * Created by Andy Stabler on 01/06/15.
 */
public class MyPriorityQueue<T> implements MyQueue<T> {

    private Object[] queue;

    private int end;

    public MyPriorityQueue(int size) {
        queue = new Object[size];
        end = -1;
    }

    @Override
    public boolean isEmpty() {
        return queue == null || end < 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (end < 0) throw new IllegalStateException("Queue empty!");
        return (T) queue[end];
    }

    @Override
    public void offer(T data) {
        if ((end + 1) >= queue.length) throw new IllegalStateException("Queue full!");
        queue[++end] = data;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T poll() {
        if (end < 0) throw new IllegalStateException("Queue empty!");
        return (T) queue[end--];
    }
}
