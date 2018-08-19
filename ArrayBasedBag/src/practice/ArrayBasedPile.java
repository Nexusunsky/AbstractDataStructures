package practice;

import java.util.Arrays;

/**
 * 基于数组实现的 PileOfBooks.
 *
 * @author: haoliu on 19/08/2018 17:10
 */
public class ArrayBasedPile implements PileOfBooks {
    private String[] array;
    private int count;

    public ArrayBasedPile(int capacity) {
        this.array = new String[capacity];
        this.count = 0;
    }

    @Override
    public int getCurrentSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void put(final String book) {
        if (isFull())
            doubleCapacity();

        count++;
        array[count - 1] = book;
    }

    @Override
    public String take() {
        if (isEmpty())
            return null;
        if (isTooBig())
            reduceArray();

        int head = --count;
        final String result = array[head];
        array[head] = null;
        return result;
    }

    private boolean isFull() {
        return count == array.length;
    }

    private void doubleCapacity() {
        int expect = 2 * array.length;
        array = Arrays.copyOf(array, expect);
    }

    private void reduceArray() {
        int expect = array.length * 3 / 4;
        if (expect < 20)
            expect = 20;
        array = Arrays.copyOf(array, expect);
    }

    private boolean isTooBig() {
        //数组大小大于 20 并且为数组大小的 3/4
        int size = array.length;
        return size > 20 && count > size * 3 / 4;
    }

    public static void main(String[] args) {
        ArrayBasedPile pile = new ArrayBasedPile(5);
        pile.take();
        pile.take();
        pile.put("1");
        pile.put("2");
        pile.take();
        pile.put("3");
        pile.take();
        pile.take();
        pile.take();
        pile.take();
        pile.put("4");
        pile.take();
        pile.put("5");
        pile.put("6");
        pile.put("7");
        pile.put("8");
        pile.put("9");
        pile.take();
    }
}
