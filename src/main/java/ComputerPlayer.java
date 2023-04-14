import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {
    /**
     * Randomly generate a string from three options.
     *
     * @return
     */
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

        System.out.println("CPU$:" + choice);

        return choice;
    }

    @Override
    public String getName() {
        return "computer";
    }
}
