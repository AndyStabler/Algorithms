package uk.co.andystabler.algorithms.sorting;

import uk.co.andystabler.algorithms.util.Lists;

import java.util.List;

/**
 * Created by Andy Stabler on 06/05/15.
 */
public class Quicksort<T extends Comparable<T>> implements Sorter<T> {

    private List<T> data;

    public Quicksort(List<T> data) {
        this.data = data;
    }

    public void sort() {
        if (data == null || data.size() < 2) return;
        quicksort(0, data.size() - 1);
    }

    private void quicksort(int start, int end) {
        if (start < end) {
            int partition = partition(start, end);
            quicksort(start, partition - 1);
            quicksort(partition + 1, end);
        }
    }

    private int partition(int start, int end) {
        T pivot = data.get(end);
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (data.get(j).compareTo(pivot) < 0)
            {
                i++;
                Lists.swap(data, i, j);
            }
        }
        Lists.swap(data, i + 1, end);
        return i + 1;
    }
}
