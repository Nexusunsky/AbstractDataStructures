package practice;

public interface Ring<T> {
    /**
     * Get current number of entries in this Ring
     *
     * @return The integer number of entries currently in the Ring.
     */
    int getCurrentSize();

    /**
     * Sees whether this Ring is empty.
     *
     * @return True if the Ring is empty or false if not.
     */
    boolean isEmpty();

    /**
     * 删除 指针目前所指向的项。如果当前Ring的size 不为 0
     *
     * @return T Either the removed entry, if the removal was successful, or null.
     */
    T remove();

    /**
     * Removes one occurrence of a given index from this ring, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or null.
     */
    boolean add(T entry);

    /**
     * 移动 ring 的指针到下一项，并且返回 指针所指向的项在环中的序列号。
     *
     * @return int Index which the ring is pointed at.
     */
    int advance();

    /**
     * 返回Ring当前所指的项
     *
     * @return T 返回当前项
     */
    T getCurrent();
}