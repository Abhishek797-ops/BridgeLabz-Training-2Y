class Product {
    private static double discount = 10.0;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
}

public class ShoppingDemo {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 60000, 2);
        Product p2 = new Product(102, "Phone", 30000, 1);
        p1.displayDetails();
        p2.displayDetails();
        Product.updateDiscount(15.0);
        p1.displayDetails();
    }
}
