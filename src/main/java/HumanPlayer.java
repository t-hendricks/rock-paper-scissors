import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    @Override
    public String inputChoice(List<String> choices) {
        Scanner input = new Scanner(System.in);
        System.out.print("User$:");
        String choice = input.nextLine();

        return choice;
    }
}
