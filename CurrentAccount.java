class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(String name, String accNumber, double balance) {
        super(name, accNumber, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > (balance + OVERDRAFT_LIMIT)) {
            throw new InsufficientBalanceException("Overdraft limit exceeded");
        }
        balance -= amount;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Current Account - Balance: " + balance);
    }
}
