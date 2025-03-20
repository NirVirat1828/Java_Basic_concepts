import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> students = new ArrayList<>();

        // Adding elements
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");

        // Insert element at index 1
        students.add(1, "David");

        // Remove element
        students.remove("Charlie");

        // Accessing elements
        System.out.println("Student at index 1: " + students.get(1));

        // Iterating using forEach
        System.out.println("Student List:");
        students.forEach(System.out::println);
    }
}

