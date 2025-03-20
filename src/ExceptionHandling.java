import java.io.*;
import java.util.Scanner;

// Custom Exception for Insufficient Balance
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Bank Account Class
class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) throws IOException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
        System.out.println("Deposited $" + amount + " successfully.");
        logTransaction("Deposit: $" + amount);
    }

    // Method to withdraw money
    public void withdraw(double amount) throws InsufficientBalanceException, IOException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Available balance: $" + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn $" + amount + " successfully.");
        logTransaction("Withdraw: $" + amount);
    }

    // Display account details
    public void displayBalance() {
        System.out.println("Account: " + accountNumber + ", Balance: $" + balance);
    }

    // Method to log transactions (Handles Checked Exception)
    private void logTransaction(String transaction) throws IOException {
        FileWriter fileWriter = new FileWriter("transactions.log", true);
        fileWriter.write(transaction + "\n");
        fileWriter.close();
    }
}

// Main Class
public class ExceptionHandling
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating a bank account
        BankAccount acc = new BankAccount("12345", 1000);
        acc.displayBalance();

        try {
            // Deposit Money (Handles IllegalArgumentException)
            System.out.print("Enter amount to deposit: ");
            double depositAmount = sc.nextDouble();
            acc.deposit(depositAmount);

            // Withdraw Money (Handles Custom Exception)
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmount = sc.nextDouble();
            acc.withdraw(withdrawAmount);
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        catch (InsufficientBalanceException e) {
            System.out.println("Insufficient Balance Exception: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("File Writing Exception: " + e.getMessage());
        }
        finally {
            System.out.println("Transaction Completed. Thank you for using our bank!");
        }

        // Display final balance
        acc.displayBalance();
    }
}

