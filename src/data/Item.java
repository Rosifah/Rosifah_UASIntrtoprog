package data;

public class Item {
    private final String name;

    private final int quantity;
    private final int weight;

    public Item(String name, int quantity, int weight) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }


    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }
}
