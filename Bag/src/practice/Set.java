package practice;

import main.ISet;

/**
 * 集合是一个不允许有重复值的特殊包
 *
 * @author: haoliu on 06/08/2018 21:23
 */
public class Set<T> implements ISet<T> {
    @Override
    public int getCurrentSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean add(final T newEntry) {
        return false;
    }

    @Override
    public boolean remove(final T anEntry) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(final T anEntry) {
        return false;
    }

    @Override
    public T[] toArray() {
        return null;
    }
}
