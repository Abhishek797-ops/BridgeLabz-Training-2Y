package OOPS.Constructors.InstanceVsClass;

class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Phone", 25000);

        System.out.println(p1.productName + " " + p1.price);
        System.out.println(p2.productName + " " + p2.price);
        System.out.println("Total Products: " + Product.totalProducts);
    }
}
