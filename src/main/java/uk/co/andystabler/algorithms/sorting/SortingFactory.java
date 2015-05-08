package uk.co.andystabler.algorithms.sorting;

import java.util.List;

/**
 * Created by Andy Stabler on 06/05/15.
 */
public class SortingFactory {

    public static <T extends Comparable<T>> void heapsort(List<T> data) {
        new Heapsort<T>(data).sort();
    }

    public static <T extends Comparable<T>> void insertionSort(List<T> data) {
        new InsertionSort<T>(data).sort();
    }

    public static <T extends Comparable<T>> void quicksort(List<T> data) {
        new Quicksort<T>(data).sort();
    }
}
