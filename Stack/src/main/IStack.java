package main;

/**
 * @author: haoliu on 2018/9/3 20:14
 */
public interface IStack<T> {

    void push(T newEntry);

    T pop();

    T peek();

    boolean isEmpty();

    void clear();

    void display();

    T[] toArray();

    /**
     * Remove top n elements.
     *
     * @param n: int, which indicates the top n element should be removed.
     */
    void remove(int n);
}
