package uk.co.andystabler.algorithms.sorting;

import uk.co.andystabler.algorithms.util.Lists;

import java.util.List;

/**
 * Created by Andy Stabler on 06/05/15.
 */
public class Heapsort<T extends Comparable<T>> implements Sorter<T> {

    private List<T> data;
    private int heapSize;

    public Heapsort(List<T> data) {
        this.data = data;
    }

    /**
     * creates a heap data structure from the unordered list, then sorts the heap by making the largest values trickle
     * down into their correct place.
     */
    public void sort() {
        if (data == null || data.size() < 2) return;
        buildHeap();
        for (int i = data.size() - 1; i >= 1; i--) {
            Lists.swap(data, 0, i);
            heapSize--;
            heapify(0);
        }
    }

    /**
     * Constructs a heap from an unordered collection
     */
    public void buildHeap() {
        heapSize = data.size() - 1;
        for (int i = (int) Math.floor((data.size() - 1) / 2); i >= 0; i--) {
            heapify(i);
        }
    }

    /**
     * maintains the heap property of the list
     * <p/>
     * assumes data[i] might be smaller than its children, which violates heap property
     *
     * @param i the index to start heapifying from
     */
    private void heapify(int i) {
        int l = left(i);
        int r = right(i);
        int largest;
        // set largest to the index with the higher value
        if (l <= heapSize && data.get(l).compareTo(data.get(i)) > 0)
            largest = l;
        else
            largest = i;
        if (r <= heapSize && data.get(r).compareTo(data.get(largest)) > 0)
            largest = r;
        // if the current node doesn't have the highest value, swap values so it does
        if (largest != i) {
            Lists.swap(data, i, largest);
            heapify(largest);
        }
    }

    /**
     * gets the index of the parent node. 0 if the current index is the root
     */
    private int parent(int i) {
        return i == 0 ? 0 : (int) Math.floor(i / 2) - 1;
    }

    /**
     * gets the index of the right child node
     */
    private int right(int i) {
        return 2 * i + 2;
    }

    /**
     * gets the index of the left child node
     */
    private int left(int i) {
        return 2 * i + 1;
    }
}
