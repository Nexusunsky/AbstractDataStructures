package practice;

/**
 * 包接口的扩展：
 * 扩展了
 * 1，union 并集
 * 2，intersection 交集
 * 3，difference 差集
 *
 * @author: haoliu on 04/08/2018 17:27
 */
interface IBagExtension<T> {

    /**
     * 两个集合的并集是将它们的内容合并到一个新的集合中。
     * Union two IBagExtension<T>`s content together for a new IBagExtension<T> instance.
     *
     * @param others Other IBagExtension<T>`s instance for union.
     * @return IBagExtension union and new a instance of IBagExtension
     */
    IBagExtension<T> union(IBagExtension<T> others);

    /**
     * 两个集合的交集是同时出现在两个集合中的项组成的新集合。
     *
     * @param others Other IBagExtension<T>`s instance to intersected with.
     * @return IBagExtension intersecting for a new IBagExtension instance result.
     */
    IBagExtension<T> intersection(IBagExtension<T> others);

    /**
     * 两个集合的差集是在一个集合中删除第二个集合中也出现的项后剩余的项组成的新集合。
     *
     * @param others Other IBagExtension<T>`s instance to intersected with.
     * @return IBagExtension difference for a new IBagExtension instance result.
     */
    IBagExtension<T> difference(IBagExtension<T> others);

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
    T remove(T anEntry);

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
}

