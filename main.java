public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Rural Bank of Nepal");
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        Customer customer = new Customer(name);
        SavingsAccount savings = new SavingsAccount(name, "SAV123", 10000);
        CurrentAccount current = new CurrentAccount(name, "CUR123", 5000);
        customer.addAccount(savings);
        customer.addAccount(current);

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            BankAccount selectedAccount;
            double amount;
            
            switch (choice) {
                case 1:
                    selectedAccount = selectAccount(scanner, savings, current);
                    System.out.print("Amount: ");
                    amount = scanner.nextDouble();
                    selectedAccount.deposit(amount);
                    break;

                case 2:
                    selectedAccount = selectAccount(scanner, savings, current);
                    System.out.print("Amount: ");
                    amount = scanner.nextDouble();
                    try {
                        selectedAccount.withdraw(amount);
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    savings.addInterest();
                    break;

                case 4:
                    for (BankAccount acc : customer.getAccounts()) {
                        acc.displayAccountDetails();
                    }
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static BankAccount selectAccount(Scanner scanner, SavingsAccount savings, CurrentAccount current) {
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("Choose: ");
        int accChoice = scanner.nextInt();
        return accChoice == 1 ? savings : current;
    }
}
