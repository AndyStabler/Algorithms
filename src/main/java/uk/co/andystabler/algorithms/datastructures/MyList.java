package uk.co.andystabler.algorithms.datastructures;

/**
 * Created by Andy Stabler on 30/05/15.
 */
public interface MyList<T> {

    /**
     * Adds an element to the beginning of the list
     *
     * @param data the data to add
     */
    void add(T data);

    /**
     * Removes an element from the list
     *
     * @param data the data to remove
     * @return true if the data was successfully removed
     */
    boolean remove(T data);

    /**
     * Removes the element at the given index from the list
     *
     * @param pos the index to remove the data from
     * @return the data at the index
     */
    T remove(int pos);

    /**
     * Searches for an element.
     *
     * @param data the dat to search for
     * @return true if found, false if not
     */
    boolean search(T data);

    /**
     * @return true if list is empty
     */
    boolean isEmpty();

    /**
     * @return the number of elements in the list
     */
    int size();

    /**
     * Adds an element to the end of the list
     *
     * @param data the data to append
     */
    void append(T data);

    /**
     * @param data the data to search for
     * @return the index of the first occurence of the data, or -1 if it was not found
     */
    int index(T data);

    /**
     * Inserts an element at the given index.
     *
     * @param index the index to add data
     * @param data  the data to add to the list
     */
    void insert(int index, T data);

    /**
     * Removes the last element from the list
     *
     * @return the last element in the list
     */
    T pop();
}
