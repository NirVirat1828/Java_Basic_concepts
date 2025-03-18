// Parent Class
class Employee {
    String name;
    double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Overridden method (base implementation)
    public double calculateSalary() {
        return baseSalary;
    }

    public void displaySalary() {
        System.out.println(name + "'s Salary: " + calculateSalary());
    }
}

// Child Class 1: Full-time Employee
class FullTimeEmployee extends Employee {
    double bonus;

    FullTimeEmployee(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    // Overriding method to customize salary calculation
    @Override
    public double calculateSalary() {
        return baseSalary + bonus;
    }
}

// Child Class 2: Part-time Employee
class PartTimeEmployee extends Employee {
    int hoursWorked;
    double hourlyRate;

    PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, 0); // Base salary is not applicable
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Overriding method to customize salary calculation
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Child Class 3: Contract-Based Employee
class ContractEmployee extends Employee {
    double contractAmount;

    ContractEmployee(String name, double contractAmount) {
        super(name, 0); // Base salary is not applicable
        this.contractAmount = contractAmount;
    }

    // Overriding method to customize salary calculation
    @Override
    public double calculateSalary() {
        return contractAmount;
    }
}

// Main Class
public class MethodOverriding {
    public static void main(String[] args) {
        // Parent class reference holding different subclass objects (Dynamic Method Dispatch)
        Employee emp1 = new FullTimeEmployee("Alice", 5000, 1000);
        Employee emp2 = new PartTimeEmployee("Bob", 40, 25);
        Employee emp3 = new ContractEmployee("Charlie", 3000);

        System.out.println("\nDisplaying Salaries:");
        emp1.displaySalary();  // Calls FullTimeEmployee's calculateSalary()
        emp2.displaySalary();  // Calls PartTimeEmployee's calculateSalary()
        emp3.displaySalary();  // Calls ContractEmployee's calculateSalary()
    }
}

