package main;

public class Item {
    private String name;
    private int price;

    public Item(final String name, final int price) {
        this.name = name;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "main.Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}