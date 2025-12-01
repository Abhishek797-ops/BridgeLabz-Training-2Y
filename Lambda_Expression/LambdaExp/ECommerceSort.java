import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Product {
    String name;
    double price;
    double rating;
    int discount;

    public Product(String name, double price, double rating, int discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", discount=" + discount + "%" +
                '}';
    }
}

public class ECommerceSort {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200.00, 4.5, 10));
        products.add(new Product("Mouse", 25.00, 4.8, 5));
        products.add(new Product("Keyboard", 75.00, 4.2, 15));
        products.add(new Product("Monitor", 300.00, 4.6, 20));

        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);

        System.out.println("\n--------------------\n");

        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("Sorted by Rating:");
        products.forEach(System.out::println);

        System.out.println("\n--------------------\n");

        products.sort(Comparator.comparingInt(p -> -p.discount));
        System.out.println("Sorted by Discount:");
        products.forEach(System.out::println);
    }
}