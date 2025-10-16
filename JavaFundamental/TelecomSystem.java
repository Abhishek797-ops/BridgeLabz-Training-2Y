interface Rechargeable {
    void recharge(double amount);

    double checkBalance();
}

class UsageDetails {
    private int calls;
    private int sms;
    private double data;

    public UsageDetails(int calls, int sms, double data) {
        this.calls = calls;
        this.sms = sms;
        this.data = data;
    }

    public int getCalls() {
        return calls;
    }

    public int getSms() {
        return sms;
    }

    public double getData() {
        return data;
    }
}

abstract class Plan implements Rechargeable {
    protected UsageDetails usage;
    protected double balance;
    public static double networkTax = 0.05;

    class DataPack {
        double dataLimit;
        double cost;

        DataPack(double dataLimit, double cost) {
            this.dataLimit = dataLimit;
            this.cost = cost;
        }

        void activate() {
            balance -= cost;
            System.out.println("Data pack of " + dataLimit + "GB activated for ₹" + cost);
        }
    }

    public Plan(UsageDetails usage) {
        this.usage = usage;
        this.balance = 0;
    }

    public abstract double calculateBill();

    @Override
    public void recharge(double amount) {
        balance += amount;
        System.out.println("Recharged with ₹" + amount + ". New Balance: ₹" + balance);
    }

    @Override
    public double checkBalance() {
        return balance;
    }
}

class PrepaidPlan extends Plan {
    public PrepaidPlan(UsageDetails usage) {
        super(usage);
    }

    @Override
    public double calculateBill() {
        double charges = usage.getCalls() * 1.0 + usage.getSms() * 0.5 + usage.getData() * 10;
        charges += charges * networkTax;
        if (balance >= charges) {
            balance -= charges;
            return charges;
        } else {
            System.out.println("Insufficient balance for prepaid plan.");
            return 0;
        }
    }
}

class PostpaidPlan extends Plan {
    public PostpaidPlan(UsageDetails usage) {
        super(usage);
    }

    @Override
    public double calculateBill() {
        double charges = usage.getCalls() * 0.8 + usage.getSms() * 0.4 + usage.getData() * 8;
        charges += charges * networkTax;
        return charges; // Postpaid billed later, no balance deduction
    }
}

class Customer {
    private final String mobileNumber;
    private String name;
    private java.util.List<Plan> plans = new java.util.ArrayList<>();

    public Customer(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public void addPlan(Plan plan) {
        plans.add(plan);
    }

    public java.util.List<Plan> getPlans() {
        return plans;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getName() {
        return name;
    }
}

class BillingSystem {
    public static void generateMonthlyBill(Customer c) {
        System.out.println("\n--- Monthly Bill for " + c.getName() + " (" + c.getMobileNumber() + ") ---");
        double total = 0;
        for (Plan plan : c.getPlans()) {
            double bill = plan.calculateBill();
            total += bill;
            System.out.println(plan.getClass().getSimpleName() + " charges: ₹" + bill);
        }
        System.out.println("Total Monthly Bill: ₹" + total);
    }
}

public class TelecomSystem {
    public static void main(String[] args) {
        UsageDetails usage1 = new UsageDetails(100, 50, 2);
        UsageDetails usage2 = new UsageDetails(200, 100, 5);

        Plan prepaid = new PrepaidPlan(usage1);
        Plan postpaid = new PostpaidPlan(usage2);

        prepaid.recharge(500);

        Customer customer = new Customer("Abhishek Singh", "9876543210");
        customer.addPlan(prepaid);
        customer.addPlan(postpaid);

        Plan.DataPack dp = prepaid.new DataPack(1.5, 100);
        dp.activate();

        BillingSystem.generateMonthlyBill(customer);
    }
}
