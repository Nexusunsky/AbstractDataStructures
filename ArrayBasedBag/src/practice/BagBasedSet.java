package practice;

import main.IBag;
import main.ResizableArrayBag;

/**
 * 使用ResizableArrayBag 来实现ISet
 *
 * @author: haoliu on 19/08/2018 15:42
 */
public class BagBasedSet<T extends Comparable> implements ISet<T> {
    private final IBag<T> bag;

    public BagBasedSet() {
        bag = new ResizableArrayBag<>();
    }

    @Override
    public int getCurrentSize() {
        return bag.getCurrentSize();
    }

    @Override
    public boolean isEmpty() {
        return bag.isEmpty();
    }

    @Override
    public boolean add(final T newEntry) {
        return bag.add(newEntry);
    }

    @Override
    public boolean remove(final T anEntry) {
        return bag.remove(anEntry);
    }

    @Override
    public T remove() {
        return bag.remove();
    }

    @Override
    public void clear() {
        bag.clear();
    }

    @Override
    public boolean contains(final T anEntry) {
        return bag.contains(anEntry);
    }

    @Override
    public T[] toArray() {
        return bag.toArray();
    }
}
