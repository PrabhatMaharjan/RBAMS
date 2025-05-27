import java.util.*;

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

abstract class BankAccount {
    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful");
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;
    public abstract void displayAccountDetails();
}
