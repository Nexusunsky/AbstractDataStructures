package practice;

/**
 * 项目：定义一个表示1.5节描述的集合并实现接口的类ArraySet，在实现中使用类ResizableArrayBag，充分证实你的实现。
 * <p>
 * 实现的ISet接口
 *
 * set 是一种特殊的包，不允许有重复项，当仅需要每次处理数据集中的一项时，可以使用集合。
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
