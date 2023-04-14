import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player implements TwoPlayers {
    /**
     * Scans user input string.
     *
     * @return String
     */
    @Override
    public String getChoice() {
        Scanner input = new Scanner(System.in);
        System.out.print("Player1$:");
        String choice = input.nextLine();

        return choice.toLowerCase().trim();
    }

    /**
     * Scans user input string.
     *
     * @return
     */
    @Override
    public String getPlayerTwoChoice() {
        Scanner input = new Scanner(System.in);
        System.out.print("Player2$:");
        String choice = input.nextLine();

        return choice.toLowerCase().trim();
    }

    @Override
    public String getName() {
        return "player 2";
    }
}
