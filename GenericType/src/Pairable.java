/**
 * @author: haoliu on 07/08/2018 21:47
 */
interface Pairable<T> {
    T getFirst();

    T getSecond();

    void changeOrder();
}
