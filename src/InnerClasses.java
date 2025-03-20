class Bank {
    private String bankName = "National Bank";
    private static double baseInterestRate = 5.0;  // Static variable for interest rate

    // Static Nested Class: Can access static members of the outer class
    static class BankInfo {
        static void displayBankInfo() {
            System.out.println("Bank Name: National Bank");
            System.out.println("Base Interest Rate: " + baseInterestRate + "%");
        }
    }

    // Member Inner Class: Customer Account
    class Customer {
        private String name;
        private double balance;

        // Constructor
        Customer(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }

        void showCustomerDetails() {
            System.out.println("Customer Name: " + name);
            System.out.println("Account Balance: $" + balance);
        }

        // Method that contains a Local Inner Class
        void applyForLoan(double loanAmount) {
            class LoanCalculator {
                double calculateEMI(double amount) {
                    return (amount * (baseInterestRate / 100)) / 12; // Simple Interest EMI
                }
            }
            LoanCalculator lc = new LoanCalculator();
            double emi = lc.calculateEMI(loanAmount);
            System.out.println("Loan Applied: $" + loanAmount);
            System.out.println("Estimated Monthly EMI: $" + emi);
        }
    }

    // Method that uses an Anonymous Inner Class
    void getSpecialInterestRate() {
        InterestRateCalculator specialRate = new InterestRateCalculator() {
            @Override
            public double getInterestRate() {
                return baseInterestRate - 0.5; // Special Discounted Rate
            }
        };
        System.out.println("Special Interest Rate: " + specialRate.getInterestRate() + "%");
    }
}

// Interface for Anonymous Inner Class
interface InterestRateCalculator {
    double getInterestRate();
}

// Main Class
public class InnerClasses {
    public static void main(String[] args) {
        // Accessing Static Nested Class
        Bank.BankInfo.displayBankInfo();

        // Creating an instance of Outer Class
        Bank bank = new Bank();

        // Creating an instance of Member Inner Class
        Bank.Customer customer1 = bank.new Customer("Alice", 5000);
        customer1.showCustomerDetails();

        // Using Local Inner Class inside a method
        customer1.applyForLoan(10000);

        // Using Anonymous Inner Class
        bank.getSpecialInterestRate();
    }
}

