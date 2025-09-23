import java.util.*;

class Product {
    String name;

    Product(String name) {
        this.name = name;
    }
}

class Order {
    List<Product> products = new ArrayList<>();

    void addProduct(Product p) {
        products.add(p);
    }
}

class CustomerEcom {
    String name;

    CustomerEcom(String name) {
        this.name = name;
    }

    Order placeOrder() {
        return new Order();
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerEcom c = new CustomerEcom("Maya");
        Order o = c.placeOrder();
        o.addProduct(new Product("Laptop"));
        System.out.println(c.name + " placed an order.");
    }
}
