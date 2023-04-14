import java.util.Arrays;
import java.util.List;

public class Menu {
    private int invalidInputs = 0;
    private HumanPlayer user = new HumanPlayer();
    private ComputerPlayer cpu = new ComputerPlayer();

    /**
     * Prints out the main menu, scans the user input
     * string, then call playMenu method or exit the
     * program based on the input string. Otherwise,
     * increment invalidInputs counter then repeat
     * with recursion.
     */
    public void mainMenu() {
        List<String> choices = Arrays.asList("play", "exit"); // [play, exit]

        System.out.println("\n============= Main Menu ==============");
        System.out.println("1. Type 'play' to play the game");
        System.out.println("2. Type 'exit' to end the program");
        System.out.println("========================================");

        try {
            String choice = choices.get(choices.indexOf(user.getChoice()));
            switch (choice) {
                case "play":
                    invalidInputs = 0;
                    playMenu();
                    break;
                case "exit":
                    System.out.println("Closing...");
                    System.exit(0);
                    break;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("\nInvalid input...");
            invalidInputs++;
            checkInvalidInputs();
        }

        mainMenu();
    }

    /**
     * Prints out the main menu, scans the user input
     * string, then call gameSession method or break out
     * of this method based on the input string.
     * Otherwise, increment invalidInputs counter then repeat
     * with recursion.
     */
    public void playMenu() {
        List<String> choices = Arrays.asList("2 players", "computer", "back"); // [2 players, computer, back]

        System.out.println("\n============= Play Menu ==============");
        System.out.println("1. Type '2 players' to play a local pvp");
        System.out.println("2. Type 'computer' to play a bot");
        System.out.println("3. Type 'back' to return to previous menu");
        System.out.println("========================================");

        try {
            String choice = choices.get(choices.indexOf(user.getChoice()));
            switch (choice) {
                case "2 players":
                    gameSession(true);
                    break;
                case "computer":
                    gameSession(false);
                    break;
                case "back":
                    break;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("\nInvalid input...");
            invalidInputs++;
            checkInvalidInputs();
            playMenu();
        }
    }

    /**
     * Takes a boolean argument for creating either a pvp game or
     * vs. computer game.
     *
     * @param pvp
     */
    public void gameSession(boolean pvp) {
        List<String> choices = Arrays.asList("rock", "paper", "scissors"); // [rock, paper, scissors

        try {
            System.out.println("\nType 'rock', 'paper', or 'scissors'");
            String playerChoice = choices.get(choices.indexOf(user.getChoice())); // player 1 scans input string
            System.out.println("\nType 'rock', 'paper', or 'scissors'");
            String player2Choice = pvp ? choices.get(choices.indexOf(user.getPlayerTwoChoice())) : cpu.getChoice();
            String player2 = pvp ? "Player 2" : "Computer";
            handleGameResult(playerChoice, player2Choice, player2);
        } catch(IndexOutOfBoundsException e) {
            System.out.println("\nInvalid input...");
            invalidInputs++;
            checkInvalidInputs();
            gameSession(pvp);
        }
    }

    /**
     * Takes two player choices and one player name as arguments
     * for creating winning messages.
     *
     * @param player1Choice
     * @param player2Choice
     * @param player2
     */
    public static void handleGameResult(String player1Choice, String player2Choice, String player2) {
        if (player1Choice.equals(player2Choice)) {
            System.out.println("\nIt's a tie!");
        } else if (player1Choice.equals("rock")) {
            System.out.println(player2Choice.equals("paper") ? "\n" + player2 + " wins!" : "\nPlayer 1 wins!");
        } else if (player1Choice.equals("paper")) {
            System.out.println(player2Choice.equals("scissors") ? "\n" + player2 + " wins!" : "\nPlayer 1 wins!");
        } else {
            System.out.println(player2Choice.equals("rock") ? "\n" + player2 + " wins!" : "\nPlayer 1 wins!");
        }
    }

    /**
     * Checks if invalidInputs is too large, then closes this
     * program.
     */
    public void checkInvalidInputs() {
        if (invalidInputs > 8) {
            System.out.println("Too many invalid inputs. Closing program!");
            System.exit(0);
        }
    }
}
