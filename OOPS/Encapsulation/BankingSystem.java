abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String acc, String name, double bal) {
        accountNumber = acc;
        holderName = name;
        balance = bal;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        if (amt > 0)
            balance += amt;
    }

    public boolean withdraw(double amt) {
        if (amt > 0 && balance >= amt) {
            balance -= amt;
            return true;
        }
        return false;
    }

    public abstract double calculateInterest();
}

interface Loanable {
    boolean applyForLoan(double amount);

    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    public double calculateInterest() {
        return balance * 0.04;
    }

    public boolean applyForLoan(double amount) {
        return calculateLoanEligibility() >= amount;
    }

    public double calculateLoanEligibility() {
        return balance * 2;
    }
}

class CurrentAccount extends BankAccount {
    public CurrentAccount(String acc, String name, double bal) {
        super(acc, name, bal);
    }

    public double calculateInterest() {
        return 0;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        BankAccount[] a = { new SavingsAccount("A1", "Sam", 10000), new CurrentAccount("A2", "Nina", 2000) };
        for (BankAccount acc : a) {
            System.out.println(
                    acc.getHolderName() + " Balance:" + acc.getBalance() + " Interest:" + acc.calculateInterest());
        }
        SavingsAccount s = (SavingsAccount) a[0];
        System.out.println("Loan eligible up to:" + s.calculateLoanEligibility());
    }
}
