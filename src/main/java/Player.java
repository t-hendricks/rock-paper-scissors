import java.util.List;

public abstract class Player {
    private int win = 0;
    private int lose = 0;

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public abstract String getChoice();
}
