class BankAccount {
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Overloaded deposit method: Deposit a fixed amount
    public void deposit() {
        balance += 100; // Default deposit amount
        System.out.println("Deposited default amount of 100. New Balance: " + balance);
    }

    // Overloaded deposit method: Deposit a specific amount
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Overloaded deposit method: Deposit using cash or check
    public void deposit(double amount, String method) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + " using " + method + ". New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit method!");
        }
    }

    // Overloaded deposit method: Deposit from another account
    public void deposit(BankAccount anotherAccount, double amount) {
        if (amount > 0 && anotherAccount.balance >= amount) {
            anotherAccount.balance -= amount;
            this.balance += amount;
            System.out.println("Transferred " + amount + " from " + anotherAccount.accountHolder + " to " + this.accountHolder);
            System.out.println(this.accountHolder + "'s New Balance: " + this.balance);
            System.out.println(anotherAccount.accountHolder + "'s New Balance: " + anotherAccount.balance);
        } else {
            System.out.println("Insufficient funds in " + anotherAccount.accountHolder + "'s account.");
        }
    }

    // Display account details
    public void display() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

public class MethodOverloading {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Alice", 1000);
        BankAccount acc2 = new BankAccount("Bob", 500);

        acc1.display();
        acc2.display();

        // Method overloading in action
        System.out.println("\nPerforming Transactions...");

        acc1.deposit();                           // Calls deposit() with no parameters
        acc1.deposit(200);                        // Calls deposit(double)
        acc1.deposit(300, "Check");               // Calls deposit(double, String)
        acc1.deposit(acc2, 400);                  // Calls deposit(BankAccount, double)

        System.out.println("\nFinal Account Balances:");
        acc1.display();
        acc2.display();
    }
}
