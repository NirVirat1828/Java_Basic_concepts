class AccountDetails {
    // private variables (data hiding)
    private long accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    AccountDetails(long accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if(initialDeposit >= 500) {
            balance = initialDeposit;
        } else {
            balance = 0;
            System.out.println("Minimum initial deposit is 500.");
        }
    }

    // Getter methods (controlled access)
    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter method (controlled modifications)
    public void setAccountHolderName(String newName) {
        accountHolderName = newName;
    }

    // Methods for transactions (controlled logic)
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("Withdraw amount must be positive.");
        } else if(amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        }
    }

    // Display account information
    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class EncapRunner {
    public static void main(String[] args) {
        // Creating Bank Account Object
        AccountDetails acc = new AccountDetails(123456789, "Alice", 1000);
        acc.displayAccountDetails();

        // Trying to access balance directly (not allowed - compilation error)
        // acc.balance = 5000;  // This line would cause an error

        // Using controlled access methods
        acc.deposit(500);
        acc.withdraw(300);
        acc.withdraw(1500); // insufficient balance

        // Modifying account holder's name
        acc.setAccountHolderName("Alice Johnson");

        System.out.println("\nUpdated Account Details:");
        acc.displayAccountDetails();
    }
}

