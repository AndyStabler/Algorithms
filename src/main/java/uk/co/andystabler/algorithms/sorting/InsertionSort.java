package uk.co.andystabler.algorithms.sorting;

import java.util.List;

/**
 * Created by Andy Stabler on 06/05/15.
 */
public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {

    public void sort(List<T> data) {
        if (data == null || data.size() < 2) return;
        System.out.println(data);
        for (int j = 1; j < data.size(); j++) {
            T key = data.get(j);
            // put data[key] into sorted list data[0 ... j-1]
            int i = j - 1;
            System.out.println("j  : " + j);
            System.out.println("key: " + key);
            System.out.println("i  : " + i);
            System.out.println(i + " > 0 ? " + (i > 0) + ". " + data.get(i) + " > " + key + "? " + (data.get(i).compareTo(key) > 0));
            while (i >= 0 && data.get(i).compareTo(key) > 0) {
                data.set(i + 1, data.get(i));
                i--;
            }
            data.set(i + 1, key);
        }
    }
}
