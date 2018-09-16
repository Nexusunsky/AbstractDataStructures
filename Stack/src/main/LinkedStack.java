package main;

/**
 * 基于链表的 栈 的实现
 *
 * @author: haoliu on 2018/9/15 20:01
 */
public class LinkedStack<T> implements IStack<T> {
    private Node topNode;

    public LinkedStack() {
        topNode = null;
    }

    @Override
    public void push(final T newEntry) {
        topNode = new Node(newEntry, topNode);
    }

    @Override
    public T pop() {
        T entry = topNode.data;
        topNode = topNode.next;
        return entry;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty.");
        return topNode.data;
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            pop();
        }
    }

    private class Node {
        private T data; //Element in stack
        private Node next; // current's next node

        private Node(final T newEntry, final Node node) {
            data = newEntry;
            next = node;
        }
    }
}
