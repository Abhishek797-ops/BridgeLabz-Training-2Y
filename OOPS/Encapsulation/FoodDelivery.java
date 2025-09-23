abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int qty) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = qty;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int q) {
        quantity = q;
    }

    public double getItemDetails() {
        return itemName + " x" + quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount();

    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }

    public String getDiscountDetails() {
        return "Veg 5%";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) {
        super(name, price, qty);
    }

    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 50;
    }

    public double applyDiscount() {
        return calculateTotalPrice() * 0.02;
    }

    public String getDiscountDetails() {
        return "NonVeg 2%";
    }
}

public class FoodDelivery {
    public static void main(String[] args) {
        FoodItem[] order = { new VegItem("Paneer", 200, 2), new NonVegItem("Chicken", 250, 1) };
        double total = 0;
        for (FoodItem f : order) {
            double tp = f.calculateTotalPrice();
            double disc = (f instanceof Discountable) ? ((Discountable) f).applyDiscount() : 0;
            System.out.println(f.getItemName() + " net:" + (tp - disc));
            total += tp - disc;
        }
        System.out.println("Order total:" + total);
    }
}
