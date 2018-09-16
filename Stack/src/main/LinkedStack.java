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

    @Override
    public void display() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty.");
        Node temp = topNode;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    @Override
    public T[] toArray() {
        Node temp = topNode;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        @SuppressWarnings("unchecked") T[] result = (T[]) new Object[length];
        temp = topNode;
        int i = 0;
        while (temp != null) {
            result[i] = temp.data;
            temp = temp.next;
        }
        return result;
    }

    @Override
    public void remove(final int n) {

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
