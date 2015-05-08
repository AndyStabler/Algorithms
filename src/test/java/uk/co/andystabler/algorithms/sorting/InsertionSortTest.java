package uk.co.andystabler.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andy Stabler on 06/05/15.
 */
public class InsertionSortTest {

    @Test
    public void emptyList_noChange() throws Exception {
        List<String> data = null;
        List<String> sorted = null;
        SortingFactory.insertionSort(data);
        Assert.assertEquals(sorted, data);
    }

    @Test
    public void oneItem_noChange() throws Exception {
        List<String> data = Collections.singletonList("Max");
        List<String> sorted = Collections.singletonList("Max");
        SortingFactory.insertionSort(data);
        Assert.assertEquals(sorted, data);
    }

    @Test
    public void TwoUnsortedStrings_sorted() throws Exception {
        List<String> data = Arrays.asList("Max", "Barney");
        List<String> sorted = Arrays.asList("Barney", "Max");
        SortingFactory.insertionSort(data);
        Assert.assertEquals(sorted, data);
    }

    @Test
    public void TwoSortedStrings_noChange() throws Exception {
        List<String> data = Arrays.asList("Barney", "Max");
        List<String> sorted = Arrays.asList("Barney", "Max");
        SortingFactory.insertionSort(data);
        Assert.assertEquals(sorted, data);
    }

    @Test
    public void ThreeStrings_sorted() throws Exception {
        List<String> data = Arrays.asList("Max", "Barney", "Andy", "Misty");
        List<String> sorted = Arrays.asList("Andy", "Barney", "Max", "Misty");
        SortingFactory.insertionSort(data);
        Assert.assertEquals(sorted, data);
    }

    @Test
    public void ThreeInts_sorted() throws Exception {
        List<Integer> data = Arrays.asList(5,4,3,1,2);
        List<Integer> sorted = Arrays.asList(1,2,3,4,5);
        SortingFactory.insertionSort(data);
        Assert.assertEquals(sorted, data);
    }
}