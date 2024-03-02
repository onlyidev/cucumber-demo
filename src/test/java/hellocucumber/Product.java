package hellocucumber;

public class Product {
    private final String name;
    private final int quantity;
    private final double price;

    public Product(String name, String quantity, String price) {
        this.name = name;
        this.quantity = Integer.parseInt(quantity);
        this.price = Integer.parseInt(price.substring(1));
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

}
