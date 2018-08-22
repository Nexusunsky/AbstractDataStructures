package main;

/**
 * 包的数据接口
 * 使用泛型来表示一类相关性的类
 *
 * @author: haoliu on 04/08/2018 17:27
 */
public interface IBag<T> {

    /**
     * Get current number of entries in this bag
     *
     * @return The integer number of entries currently in the bag.
     */
    int getCurrentSize();

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty or false if not.
     */
    boolean isEmpty();

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    boolean add(T newEntry);

    /**
     * Removes one specified a entry from this bag, if possible.
     *
     * @return T Either the removed entry, if the removal was successful, or null.
     */
    T remove();

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     *
     * @param anEntry the entry to be removed
     * @return Either the removed entry, if the removal was successful, or null.
     */
    boolean remove(T anEntry);

    /**
     * Removes all entries from this bag.
     */
    void clear();

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    int getFrequencyOf(T anEntry);

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry appears in the bag. of false if not.
     */
    boolean contains(T anEntry);

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    T[] toArray();

    /**
     * remove every entry in the bag.
     *
     * @param entry target entry should be removed.
     * @return boolean True if removeEvery success, otherwise false.
     */
    boolean removeEvery(T entry);
}

