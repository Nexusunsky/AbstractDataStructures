package practice;

/**
 * @author: haoliu on 19/08/2018 20:23
 */
public class ArrayBasedRing<T> implements Ring<T> {
    private T[] array;
    private int entrySize;
    private int curso;

    public ArrayBasedRing(int capacity) {
        @SuppressWarnings("unchecked") final T[] temp = (T[]) new Object[capacity];
        this.array = temp;
        this.entrySize = 0;
        this.curso = 0;
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
    public boolean add(final T entry) {
        if (entrySize == array.length)
            return false;

        if (curso == entrySize) {
            T temp = array[curso];
            array[curso] = entry;
            array[++entrySize] = temp;
            return true;
        }

        System.arraycopy(array, curso, array, curso + 1, entrySize - curso);
        entrySize++;
        array[curso] = entry;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty())
            return null;

        if (curso == entrySize) {
            T temp = array[curso];
            entrySize--;
            curso--;
            return temp;
        }

        T temp = array[curso];
        System.arraycopy(array, curso + 1, array, curso, entrySize - 1 - curso);
        entrySize--;
        array[entrySize] = null;
        return temp;
    }

    @Override
    public int advance() {
        curso++;
        curso %= entrySize;
        return curso;
    }

    @Override
    public T getCurrent() {
        return array[curso];
    }

    public static void main(String[] args) {
        ArrayBasedRing<String> ring = new ArrayBasedRing<>(5);
        ring.add("1");
        ring.remove();
        ring.add("2");
        ring.add("3");
        ring.add("4");
        ring.advance();
        ring.remove();
        ring.remove();
        ring.advance();
        ring.remove();
        ring.add("5");
        ring.add("6");
        ring.add("7");
        ring.advance();
        ring.add("8");
        ring.advance();
        ring.add("9");
        ring.remove();
        ring.add("0");
    }
}
