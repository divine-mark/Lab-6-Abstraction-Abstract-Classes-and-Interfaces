abstract class Account {
    private final String accountNumber;
    protected double balance;

    protected Account(String accountNumber, double openingBalance) {
        if (openingBalance < 0) throw new IllegalArgumentException("Negative opening balance");
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    // Concrete method shared by all account types
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
        balance += amount;
        System.out.printf("Deposited %.2f, new balance %.2f%n", amount, balance);
    }

    // Abstract method — each account type defines its own fee
    public abstract double monthlyFee();

    @Override
    public String toString() {
        return String.format("%s [%s] balance=%.2f monthlyFee=%.2f",
                getClass().getSimpleName(), accountNumber, balance, monthlyFee());
    }
}

class SavingsAccount extends Account {
    private static final double FEE = 10.0;

    SavingsAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override public double monthlyFee() { return FEE; }
}

class CurrentAccount extends Account {
    private static final double FEE = 25.0;

    CurrentAccount(String accountNumber, double openingBalance) {
        super(accountNumber, openingBalance);
    }

    @Override public double monthlyFee() { return FEE; }
}

public class AccountDemo {
    public static void main(String[] args) {
        // Account a = new Account("X", 100); // COMPILE ERROR: abstract

        Account[] accounts = {
            new SavingsAccount("SAV-001", 1000),
            new CurrentAccount("CUR-001", 2000)
        };

        for (Account a : accounts) {
            a.deposit(500);
            System.out.println(a);
            System.out.println("---");
        }
    }
}