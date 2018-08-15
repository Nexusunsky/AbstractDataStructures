/**
 * Array based Bag.
 *
 * @author: haoliu on 08/08/2018 22:33
 */
public final class ArrayBag<T> implements IBag<T> {
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 100000;
    private boolean initialized = false;
    private final T[] arrayBag;
    private int entryNumber;

    public ArrayBag(int capacity) {
        if (capacity <= MAX_CAPACITY) {
            @SuppressWarnings("unchecked") final T[] temp = (T[]) new Object[capacity];
            this.arrayBag = temp;
            this.entryNumber = 0;
            this.initialized = true;
        } else {
            throw new IllegalStateException("Attempt to create a big object.");
        }
    }

    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public boolean add(final T newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else {
            arrayBag[entryNumber] = newEntry;
            entryNumber++;
        }
        return result;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked") final T[] result = (T[]) new Object[entryNumber];
        System.arraycopy(arrayBag, 0, result, 0, entryNumber);
        return result;
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
        return removeAtIndex(entryNumber - 1);
    }

    @Override
    public boolean remove(final T anEntry) {
        checkInitialization();
        T result = removeAtIndex(entryNumber - 1);
        return anEntry.equals(result);
    }


    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
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
        return getIndexOf(anEntry) == -1;
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
            throw new SecurityException("ArrayBag object is not initialized properly.");
        }
    }
}
