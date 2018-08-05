package main;

/**
 * 存钱罐
 * A class that implements a piggy bank by using a bag
 *
 * @author: haoliu on 04/08/2018 21:43
 */
public class PiggyBank {
    private IBag<Coin> coins;

    public PiggyBank() {
        coins = new Bag();
    }

    public boolean add(Coin aCoin) {
        return coins.add(aCoin);
    }

    public Coin remove() {
        return coins.remove();
    }

    public boolean isEmpty() {
        return coins.isEmpty();
    }
}
