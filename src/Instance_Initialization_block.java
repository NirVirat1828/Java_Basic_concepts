class Vehicle {
    Vehicle() {
        System.out.println("Vehicle Constructor Called");
    }

    {
        System.out.println("Vehicle Instance Initialization Block-1");
    }

    {
        System.out.println("Vehicle Instance Initialization Block-2");
    }
}

class Car extends Vehicle {
    String model;

    Car() {
        this("Default Model"); // Constructor chaining
        System.out.println("Car Default Constructor Called");
    }

    Car(String model) {
        this.model = model;
        System.out.println("Car Parameterized Constructor Called with model: " + model);
    }

    {
        System.out.println("Car Instance Initialization Block-1");
    }

    {
        System.out.println("Car Instance Initialization Block-2");
    }
}

public class Instance_Initialization_block {
    public static void main(String[] args) {
        System.out.println("Creating First Car Object...");
        Car car1 = new Car();

        System.out.println("\nCreating Second Car Object...");
        Car car2 = new Car("Tesla Model X");
    }
}
