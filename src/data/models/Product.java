package data.models;

public class Product {
    public final String id;
    public final String title;
    public final String descriptions;
    public final int price;
    public final boolean available;

    public Product(String id, String title, String descriptions, int price, boolean available) {
        this.id = id;
        this.title = title;
        this.descriptions = descriptions;
        this.price = price;
        this.available = available;
    }
}
