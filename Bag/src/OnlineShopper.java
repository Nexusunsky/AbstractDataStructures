/**
 * @author: haoliu on 04/08/2018 21:11
 */
public class OnlineShopper {
    public static void main(String[] args) {
        Item[] items = {
                new Item("Bird feeder", 2050),
                new Item("Squirrel guard", 1547),
                new Item("Bird bath", 4499),
                new Item("Sunflower seeds", 1295),
        };

        IBag<Item> shoppingCart = new Bag();
        int totalCost = 0;

        for (Item nextItem : items) {
            shoppingCart.add(nextItem);
            totalCost += nextItem.getPrice();
        }

        while (!shoppingCart.isEmpty()) {
            System.out.print(shoppingCart.remove());

        }

        System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." + totalCost % 100);
    }
}
