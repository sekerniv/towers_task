import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        TowersGame game = new TowersGame(2);
        boolean isBotVsPerson = true;  // Set to true for bot vs person, false for two-person game
        playGame(game, isBotVsPerson);
    }

    public static void playGame(TowersGame game, boolean isBotVsPerson) {
        Scanner input = new Scanner(System.in);

        // Initialize players
        Player player1;
        if (isBotVsPerson) {
            player1 = new Player("Bot", true);
            System.out.println("Player 1 is a bot name " + player1.getName());
        } else {
            System.out.println("Player 1, please enter your name");
            String name1 = input.next();
            player1 = new Player(name1, false);
        }

        System.out.println("Player 2, please enter your name");
        String name2 = input.next();
        Player player2 = new Player(name2, false);

        // Main game loop
        while (game.getWinner() == -1) {
            game.draw();
            Player currentPlayer = (game.getCurPlayer() == 1) ? player1 : player2;

            System.out.println(currentPlayer.getName() + ", it's your turn");
            Move move = currentPlayer.getNextMove(game);

            System.out.println("Playing: " + move);

            if (!game.play(move)) {
                System.out.println("Invalid move");
            }
        }

        // Game over - declare winner
        game.draw();
        if (game.getWinner() == 1) {
            System.out.println("Player 1 - " + player1.getName() + " wins");
        } else {
            System.out.println("Player 2 - " + player2.getName() + " wins");
        }
    }
}