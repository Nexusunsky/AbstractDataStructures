package practice;

import java.util.Arrays;

/**
 * 基于可变数组实现的Set
 * 尽量简单
 *
 * @author: haoliu on 19/08/2018 15:58
 */
public final class ResizableArraySet<T> implements ISet<T> {
    private static final int DEFAULT_CAPACITY = 25;
    private T[] array;
    private int entrySize;

    public ResizableArraySet() {
        this(DEFAULT_CAPACITY);
    }

    public ResizableArraySet(int capacity) {
        @SuppressWarnings("unchecked") final T[] temp = (T[]) new Object[capacity];
        this.array = temp;
        this.entrySize = 0;
    }

    @Override
    public int getCurrentSize() {
        return entrySize;
    }

    @Override
    public boolean isEmpty() {
        return entrySize == 0;
    }

    @Override
    public boolean add(final T newEntry) {
        if (contains(newEntry))
            return false;

        if (isArrayFull())
            doubleCapacity();

        array[entrySize] = newEntry;
        entrySize++;
        return true;
    }


    @Override
    public boolean remove(final T anEntry) {
        if (isTooBig())
            reduceArray();

        int index = getIndexOf(anEntry);
        T result = removeAtIndex(index);
        return anEntry.equals(result);
    }


    @Override
    public T remove() {
        if (isTooBig())
            reduceArray();

        return removeAtIndex(entrySize - 1);
    }

    @Override
    public void clear() {
        while (!isEmpty())
            remove();
    }

    @Override
    public boolean contains(final T anEntry) {
        int index = getIndexOf(anEntry);
        if (index > 1)
            throw new IllegalStateException("Set has two same entry: " + anEntry.toString());
        return index == 1;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked") final T[] result = (T[]) new Object[array.length];
        System.arraycopy(array, 0, result, 0, entrySize);
        return result;
    }

    private void doubleCapacity() {
        int expect = 2 * array.length;
        array = Arrays.copyOf(array, expect);
    }

    private boolean isArrayFull() {
        return entrySize == array.length;
    }

    private void reduceArray() {
        int expect = array.length * 3 / 4;
        if (expect < 20)
            expect = 20;
        array = Arrays.copyOf(array, expect);
    }

    private boolean isTooBig() {
        //元素个数大于 20 并且为数组大小的 3/4
        return entrySize > 20 && entrySize > array.length * 3 / 4;
    }

    private T removeAtIndex(final int index) {
        if (index < 0 || index > entrySize)
            return null;

        T result = array[index];
        array[index] = array[entrySize - 1];
        array[entrySize - 1] = null;
        entrySize--;
        return result;
    }

    private int getIndexOf(final T anEntry) {
        int result = -1, index = 0;
        boolean looking = true;
        while (looking && index < entrySize) {
            if (anEntry.equals(array[index])) {
                looking = false;
                result = index;
            }
            index++;
        }
        return result;
    }
}
