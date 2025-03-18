class Player {
    String name;
    int id;
    static String gameName = "BattleQuest";  // Static variable
    static int playerCount;                 // Static variable to count instances

    // Static block to initialize static variables
    static {
        playerCount = 0;
        System.out.println("Static block executed: Initializing Player class.");
    }

    // Constructor increments playerCount every time a new player is created
    Player(String name, int id) {
        this.name = name;
        this.id = id;
        playerCount++;
    }

    // Static method to display general game info
    static void displayGameInfo() {
        System.out.println("Welcome to " + gameName);
        System.out.println("Total Players: " + playerCount);
    }

    // Non-static method to display individual player details
    void displayPlayerInfo() {
        System.out.println("Player Name: " + name);
        System.out.println("Player ID: " + id);
        System.out.println("Game: " + gameName);
    }
}

public class StaticMembers {
    public static void main(String[] args) {
        // Static method call without object creation
        Player.displayGameInfo();

        System.out.println("\nCreating Players...");
        Player player1 = new Player("Alice", 101);
        Player player2 = new Player("Bob", 102);
        Player player3 = new Player("Charlie", 103);

        // Calling non-static methods using objects
        System.out.println("\nPlayer Details:");
        player1.displayPlayerInfo();
        System.out.println();
        player2.displayPlayerInfo();
        System.out.println();
        player3.displayPlayerInfo();

        // Accessing static method again to see updated player count
        System.out.println("\nUpdated Game Info:");
        Player.displayGameInfo();
    }
}

