import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
    @Override
    public String getChoice() {
        Random rand = new Random();
        int num = rand.nextInt(3);
        String choice = "";

        switch (num) {
            case 0:
                choice = "rock";
                break;
            case 1:
                choice = "paper";
                break;
            case 2:
                choice = "scissors";
                break;
        }

        return choice;
    }
}
