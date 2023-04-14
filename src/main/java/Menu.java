import java.util.Arrays;
import java.util.List;

public class Menu {
    private int invalidInputs = 0;

    public void mainMenu(Player user) {
        List<String> choices = Arrays.asList("play", "exit"); // [play, exit]

        System.out.println("\n============= Main Menu ==============");
        System.out.println("1. Type 'play' to play the game");
        System.out.println("2. Type 'exit' to end the program");
        System.out.println("========================================");

        try {
            String choice = choices.get(choices.indexOf(user.getChoice()));
            switch (choice) {
                case "play":
                    Player aiPlayer = new ComputerPlayer();
                    gameSession(user, aiPlayer);
                    break;
                case "exit":
                    System.out.println("Closing...");
                    System.exit(0);
                    break;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("\nInvalid input...");
        }

        mainMenu(user);
    }

    public void playMenu() {

    }

    public void gameSession(Player player1, Player player2) {
        List<String> choices = Arrays.asList("rock", "paper", "scissors");
        System.out.println("\nType 'rock', 'paper', or 'scissors'");

        try {
            String playerChoice = choices.get(choices.indexOf(player1.getChoice()));
            String computerChoice = player2.getChoice();
            handleGameResult(playerChoice, computerChoice);

        } catch(IndexOutOfBoundsException e) {
            System.out.println("\nInvalid input...");
            gameSession(player1, player2);
        }
    }

    public static void handleGameResult(String player1Choice, String player2Choice) {
        if (player1Choice.equals(player2Choice)) {
            System.out.println("\nIt's a tie!");
        } else if (player1Choice.equals("rock")) {
            System.out.println(player2Choice.equals("paper") ? "\nPlayer 1 lose!" : "\nPlayer 1 wins!");
        } else if (player1Choice.equals("paper")) {
            System.out.println(player2Choice.equals("scissors") ? "\nPlayer 1 lose!" : "\nPlayer 1 wins!");
        } else {
            System.out.println(player2Choice.equals("rock") ? "\nPlayer 1 lose!" : "\nPlayer 1 wins!");
        }
    }
}
