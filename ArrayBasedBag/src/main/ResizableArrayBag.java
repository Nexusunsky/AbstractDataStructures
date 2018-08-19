package main;

import java.util.Arrays;

/**
 * Array based and resizable Bag.
 *
 * @author: haoliu on 08/08/2018 22:33
 */
public final class ResizableArrayBag<T extends Comparable> implements IBag<T> {
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 100000;
    private boolean initialized = false;
    private T[] arrayBag;
    private int entryNumber;

    public ResizableArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            initBag(capacity);
        } else {
            throw new IllegalStateException("Attempt to create a big object.");
        }
    }

    public ResizableArrayBag(T[] origin) {
        int size = origin.length;
        if (size <= MAX_CAPACITY) {
            this.arrayBag = Arrays.copyOf(origin, size);
            this.entryNumber = 0;
            this.initialized = true;
        } else {
            throw new IllegalStateException("Attempt to create a big object.");
        }
    }

    public ResizableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(final T newEntry) {
        checkInitialization();
        if (isArrayFull()) {
            doubleCapacity();
        }
        arrayBag[entryNumber] = newEntry;
        entryNumber++;
        return true;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked") final T[] result = (T[]) new Object[entryNumber];
        System.arraycopy(arrayBag, 0, result, 0, entryNumber);
        return result;
    }

    @Override
    public T replace(final int index, final T replacement) {
        checkInitialization();
        if (index > arrayBag.length || index < 0)
            throw new IllegalStateException("Index is invalid.");
        if (index > entryNumber)
            return null;

        return arrayBag[index];
    }

    @Override
    public boolean removeEvery(final T entry) {
        checkInitialization();
        if (getIndexOf(entry) == -1)
            return false;

        T[] temp = Arrays.copyOf(arrayBag, arrayBag.length);
        for (int i = 0; i < entryNumber; i++) {
            if (entry.equals(arrayBag[i])) {
                temp[i] = temp[entryNumber - 1];
                temp[entryNumber - 1] = null;
                entryNumber--;
            }
        }
        arrayBag = temp;
        return true;
    }

    @Override
    public int getCurrentSize() {
        return entryNumber;
    }

    @Override
    public boolean isEmpty() {
        return entryNumber == 0;
    }

    @Override
    public T remove() {
        checkInitialization();
        if (isTooBig())
            reduceArray();

        return removeAtIndex(entryNumber - 1);
    }

    @Override
    public boolean remove(final T anEntry) {
        checkInitialization();
        if (isTooBig())
            reduceArray();

        int index = getIndexOf(anEntry);
        T result = removeAtIndex(index);
        return anEntry.equals(result);
    }

    @Override
    public void clear() {
        checkInitialization();
        initBag(arrayBag.length);
    }

    /**
     * 比较对象时必须使用equals而不是使用==
     */
    @Override
    public int getFrequencyOf(final T anEntry) {
        checkInitialization();
        int counter = 0;
        //固定次数的循环
        for (int i = 0; i < entryNumber; i++) {
            if (anEntry.equals(arrayBag[i]))
                counter++;
        }
        return counter;
    }

    @Override
    public boolean contains(final T anEntry) {
        checkInitialization();
        return getIndexOf(anEntry) > -1;
    }

    public T getMin() {
        checkInitialization();
        T result = arrayBag[0];
        for (final T entry : arrayBag) {
            if (result.compareTo(entry) > 0)
                result = entry;
        }
        return result;
    }

    public T getMax() {
        checkInitialization();
        T result = arrayBag[0];
        for (final T entry : arrayBag) {
            if (result.compareTo(entry) < 0)
                result = entry;
        }
        return result;
    }

    public T removeMin() {
        T min = getMin();
        remove(min);
        return min;
    }

    public T removeMax() {
        T max = getMax();
        remove(max);
        return max;
    }

    public IBag<T> getAllLessThan(Comparable<T> anObject) {
        @SuppressWarnings("unchecked") final T[] temp = (T[]) new Object[entryNumber];
        int index = 0;
        for (final T entry : arrayBag) {
            if (anObject.compareTo(entry) > 0)
                temp[index] = entry;
            index++;
        }
        return new ResizableArrayBag<>(temp);
    }

    /**
     * 两个相等的包应含有相同个数的项，每个项出现在每个包中个数应该相等，每个数组中的项的次序是无关的。
     */
    public boolean equals(final IBag<T> others) {
        if (others.getCurrentSize() != entryNumber)
            return false;

        for (final T entry : arrayBag) {
            if (getFrequencyOf(entry) != others.getFrequencyOf(entry))
                return false;
        }

        return true;
    }

    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean looking = true;
        int index = 0;
        while (looking && (index < entryNumber)) {
            if (anEntry.equals(arrayBag[index])) {
                looking = false;
                where = index;
            }
            index++;
        }
        return where;
    }

    private void doubleCapacity() {
        int newLength = 2 * arrayBag.length;
        checkCapacity(newLength);
        arrayBag = Arrays.copyOf(arrayBag, newLength);
    }

    private void checkCapacity(final int capacity) {
        if (capacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a big whose capacity exeeds allowed maximum of " + MAX_CAPACITY);
        }
    }

    /**
     * 前置条件：包不能为空，index为有效值
     * 删除的策略为将最后一项移动到指定index处，并将最后一项置空
     */
    private T removeAtIndex(int index) {
        T result = null;
        if (!isEmpty() && index >= 0) {
            result = arrayBag[index];
            arrayBag[index] = arrayBag[entryNumber - 1];
            arrayBag[entryNumber - 1] = null;
            entryNumber--;
        }

        return result;
    }

    private boolean isArrayFull() {
        return entryNumber >= arrayBag.length;
    }

    private void checkInitialization() {
        if (!initialized) {
            throw new SecurityException("main.ArrayBag object is not initialized properly.");
        }
    }

    private void initBag(final int capacity) {
        @SuppressWarnings("unchecked") final T[] temp = (T[]) new Object[capacity];
        this.arrayBag = temp;
        this.entryNumber = 0;
        this.initialized = true;
    }

    /**
     * 创建一个新数组，其大小是当前数组大小的3/4，且数组的大小大于20。
     */
    private void reduceArray() {
        int capacity = arrayBag.length * 3 / 4;
        if (capacity < 20)
            capacity = 20;
        arrayBag = Arrays.copyOf(arrayBag, capacity);
    }

    /**
     * 如果包中的项数小于数组大小的一半且数组的大小大于20，这个方法返回真。
     */
    private boolean isTooBig() {
        int size = arrayBag.length;
        return size > 20 && entryNumber < size / 2;
    }
}
