import java.util.Arrays;
import java.util.List;

public class Menu {
    private int invalidInputs = 0;

    public int getInvalidInputs() {
        return invalidInputs;
    }

    public void setInvalidInputs(int invalidInputs) {
        this.invalidInputs = invalidInputs;
    }

    public void mainMenu(Player user) {
        List<String> choices = Arrays.asList("play", "exit"); // [play, exit]

        System.out.println("\n============= Menu ==============");
        System.out.println("1. Type 'play' to play the game");
        System.out.println("2. Type 'exit' to end the program");
        System.out.println("=================================");

        try {
            String choice = choices.get(choices.indexOf(user.inputChoice(choices).toLowerCase()));

            switch (choice) {
                case "play":
                    gameSession();
                case "exit":

            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("\nInvalid input...");
            mainMenu(user);
        }
    }

    public void playMenu() {

    }

    public void gameSession() {
        System.out.println("Let's play!");
    }
}
