public class Game {
    public static void main(String[] args) {
        Player user = new HumanPlayer();
        Menu menu = new Menu();

        menu.mainMenu(user);
    }
}
