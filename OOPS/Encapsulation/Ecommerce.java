abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.productId = id;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }

    public abstract double calculateDiscount();
}

interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    public double calculateTax() {
        return getPrice() * 0.18;
    }

    public String getTaxDetails() {
        return "GST 18%";
    }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return getPrice() * 0.15;
    }

    public double calculateTax() {
        return getPrice() * 0.05;
    }

    public String getTaxDetails() {
        return "GST 5%";
    }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price) {
        super(id, name, price);
    }

    public double calculateDiscount() {
        return 0;
    }
}

public class ECommerce {
    public static void printFinal(Product p) {
        double price = p.getPrice();
        double discount = p.calculateDiscount();
        double tax = (p instanceof Taxable) ? ((Taxable) p).calculateTax() : 0;
        double finalPrice = price + tax - discount;
        System.out.println(p.getName() + " final:" + finalPrice);
    }

    public static void main(String[] args) {
        Product[] items = {
                new Electronics("E1", "Phone", 20000),
                new Clothing("C1", "Shirt", 1000),
                new Groceries("G1", "Rice", 500)
        };
        for (Product p : items)
            printFinal(p);
    }
}
