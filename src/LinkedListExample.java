import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Adding elements at head and tail
        numbers.addFirst(5);
        numbers.addLast(50);

        // Removing elements
        numbers.removeFirst();
        numbers.removeLast();

        // Iterating through LinkedList
        System.out.println("Linked List Elements:");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }
}

