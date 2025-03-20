import java.util.*;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> history = new Stack<>();

        // Pushing pages onto the stack
        history.push("Homepage");
        history.push("Login Page");
        history.push("Dashboard");
        history.push("Settings");

        // Peek at the top element
        System.out.println("Current Page: " + history.peek());

        // Going back (popping from stack)
        System.out.println("Going back from: " + history.pop());
        System.out.println("Now on: " + history.peek());

        // Printing full history
        System.out.println("Browsing History: " + history);
    }
}

