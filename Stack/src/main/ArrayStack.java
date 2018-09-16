package main;

import java.util.Arrays;

/**
 * 数组实现的 Stack
 *
 * @author: haoliu on 2018/9/16 21:39
 */
public class ArrayStack<T> implements IStack<T> {
    private T[] stack;
    private int topIndex;
    private boolean initialized;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        checkCapacity(capacity);
        initArray(capacity);
        initialized = true;
    }

    @Override
    public void push(final T newEntry) {
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newEntry;
        topIndex++;
    }

    @Override
    public T pop() {
        checkInitialization();
        if (isEmpty())
            throw new RuntimeException("Stack is empty.");

        T t = stack[topIndex];
        stack[topIndex] = null;
        topIndex--;
        return t;
    }

    @Override
    public T peek() {
        checkInitialization();
        if (isEmpty())
            throw new RuntimeException("Stack is empty.");
        return stack[topIndex];
    }

    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public void clear() {
        initArray(stack.length);
    }

    private void initArray(final int length) {
        @SuppressWarnings("unchecked") T[] tempStack = (T[]) new Object[length];
        stack = tempStack;
        topIndex = -1;
    }

    private void checkInitialization() {
        if (!initialized)
            throw new RuntimeException("Stack does not been initialized.");
    }

    private void ensureCapacity() {
        int originLength = stack.length;
        if (topIndex == originLength - 1) {
            int newLength = originLength * 2;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    private void checkCapacity(final int length) {
        if (length > MAX_CAPACITY)
            throw new RuntimeException("Expected length is too big to allocate.");
    }
}
