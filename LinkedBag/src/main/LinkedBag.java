package main;

/**
 * 基于链表实现的 Bag
 *
 * @author: haoliu on 2018/8/22 15:56
 */
public class LinkedBag<T> implements IBag<T> {
    private Node firstNode;
    private int entryNumber;

    public LinkedBag() {
        this.firstNode = null;
        this.entryNumber = 0;
    }

    @Override
    public int getCurrentSize() {
        return entryNumber;
    }

    @Override
    public boolean isEmpty() {
        return entryNumber == 0 || firstNode == null;
    }

    @Override
    public boolean add(final T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.next = firstNode;
        firstNode = newNode;
        entryNumber++;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty())
            return null;

        T result = firstNode.data;
        firstNode = firstNode.next;
        entryNumber--;
        return result;
    }

    @Override
    public boolean remove(final T anEntry) {
        boolean result = false;
        Node ref = getReferenceOf(anEntry);

        if (ref != null) {
            ref.data = firstNode.data;
            firstNode = firstNode.next;
            entryNumber--;
            result = true;
        }
        return result;
    }

    @Override
    public boolean removeEvery(final T entry) {
        boolean result = false;

        Node node = getReferenceOf(entry);
        while (node != null) {
            node.data = firstNode.data;
            firstNode = firstNode.next;
            entryNumber--;
            node = getReferenceOf(entry);
        }

        return result;
    }

    private Node getReferenceOf(T anEntry) {
        boolean found = false;
        int counter = 0;
        Node currentNode = firstNode;

        while (!found && counter < entryNumber) {
            if (anEntry.equals(currentNode.data))
                found = true;
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode;
    }

    @Override
    public void clear() {
        while (isEmpty()) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(final T anEntry) {
        if (isEmpty())
            return 0;

        int frequency = 0;
        int loopCount = 0;
        Node currentNode = firstNode;

        while ((loopCount < entryNumber) && currentNode != null) {
            if (anEntry.equals(currentNode.data))
                frequency++;

            currentNode = currentNode.next;
            loopCount++;
        }
        return frequency;
    }

    @Override
    public boolean contains(final T anEntry) {
        return getReferenceOf(anEntry) != null;
    }

    @Override
    public T[] toArray() {
        @SuppressWarnings("unchecked") final T[] result = (T[]) new Object[entryNumber];
        int index = 0;
        Node currentNode = firstNode;

        while (currentNode != null) {
            result[index] = currentNode.data;
            currentNode = currentNode.next;
            index++;
        }
        return result;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(final T data) {
            this(data, null);
        }

        private Node(final T data, final Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
