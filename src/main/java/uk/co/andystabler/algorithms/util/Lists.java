package uk.co.andystabler.algorithms.util;

import java.util.List;

/**
 * Created by Andy Stabler on 08/05/15.
 */
public class Lists {

    /**
     * swap values at the given indices
     */
    public static<T> void swap(List<T> data, int i, int j)
    {
        if (i < 0 || i >= data.size() || j < 0 || j >= data.size())
            return;
        T temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
