package oops;

public class Cart {
    private String name;
    private int quantity;
    private double price;
    private static String pord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static String getPord() {
        return pord;
    }

    public static void setPord(String pord) {
        Cart.pord = pord;
    }

    public Cart(String name, int quantity, double price, String pord) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.pord = pord;
    }
}
