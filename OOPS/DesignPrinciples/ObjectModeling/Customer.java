import java.util.*;

public class Customer {
    String name;
    double balance;

    Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void viewBalance() {
        System.out.println(name + " balance: " + balance);
    }
}

class Bank {
    List<Customer> customers = new ArrayList<>();

    void openAccount(Customer c) {
        customers.add(c);
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer c1 = new Customer("Alice", 5000);
        bank.openAccount(c1);
        c1.viewBalance();
    }
}
