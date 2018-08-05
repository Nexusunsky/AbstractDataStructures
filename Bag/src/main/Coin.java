package main;

/**
 * main.Coin
 *
 * @author: haoliu on 04/08/2018 21:44
 */
public class Coin {
    private String coinName;
    private int coinValue;

    public Coin(final String coinName, final int coinValue) {
        this.coinName = coinName;
        this.coinValue = coinValue;
    }

    public String getCoinName() {
        return coinName;
    }

    public int getCoinValue() {
        return coinValue;
    }
}
