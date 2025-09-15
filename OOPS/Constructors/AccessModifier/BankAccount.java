package OOPS.Constructors.AccessModifier;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("A1001", "Rahul", 5000);
        System.out.println(acc.accountNumber + " " + acc.accountHolder + " " + acc.getBalance());

        acc.setBalance(7000);
        System.out.println("Updated Balance: " + acc.getBalance());

        SavingsAccount sa = new SavingsAccount("A1002", "Riya", 8000, 5);
        sa.showDetails();
    }
}

class SavingsAccount extends BankAccount {
    int interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, int interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void showDetails() {
        System.out.println(accountNumber + " " + accountHolder + " " + interestRate + "%");
    }
}
