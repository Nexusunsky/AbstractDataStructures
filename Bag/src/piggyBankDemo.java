/**
 * @author: haoliu on 04/08/2018 21:49
 */
public class piggyBankDemo {
    public static void main(String[] args) {
        PiggyBank myBank = new PiggyBank();

        addCoin(new Coin("2010", 1), myBank);
        addCoin(new Coin("2011", 5), myBank);
        addCoin(new Coin("2000", 10), myBank);
        addCoin(new Coin("2012", 25), myBank);

        int coinValue = 0;
        while (!myBank.isEmpty()) {
            Coin removedCoin = myBank.remove();
            System.out.println("Removed a " + removedCoin.getCoinName());
            coinValue += removedCoin.getCoinValue();
        }
        System.out.println("All done. Removed " + coinValue + " cents.");
    }

    private static void addCoin(Coin aCoin, PiggyBank aBank) {
        if (aBank.add(aCoin))
            System.out.println("Added a  " + aCoin.getCoinName());
        else
            System.out.println("Tried to add a " + aCoin.getCoinName() + "but failed.");
    }
}
