/**
 * @author: haoliu on 07/08/2018 21:48
 */
class OrderedPair<T> implements Pairable<T> {

    private T first, second;

    public OrderedPair(final T first, final T second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public T getFirst() {
        return first;
    }

    @Override
    public T getSecond() {
        return second;
    }

    @Override
    public void changeOrder() {
        T temp = first;
        first = second;
        second = temp;
    }

    @Override
    public String toString() {
        return "OrderedPair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
