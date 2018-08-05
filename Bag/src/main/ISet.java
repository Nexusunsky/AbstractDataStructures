package main;

/**
 * An Interface that describe the operation of a set of objects.
 *
 * @author: haoliu on 04/08/2018 22:14
 */
public interface ISet<T> {
    int getCurrentSize();

    boolean isEmpty();

    /**
     * Adds a new entry to this set, avoiding duplicates.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful,
     * or False if the item already is in the set.
     */
    boolean add(T newEntry);

    /**
     * Removes a specific entry from this set, if possible.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    boolean remove(T anEntry);

    T remove();

    void clear();

    boolean contains(T anEntry);

    T[] toArray();
}
