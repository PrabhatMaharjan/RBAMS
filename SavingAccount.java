class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.05;

    public SavingsAccount(String name, String accNumber, double balance) {
        super(name, accNumber, balance);
    }

    public void addInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account - Balance: " + balance);
    }
}
