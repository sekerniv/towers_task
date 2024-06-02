import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        TowersGame game = new TowersGame(2);
        boolean isBotVsPerson = true;  // Set to true for bot vs person, false for two-person game
        playGame(game, isBotVsPerson);
    }

    public static void playGame(TowersGame game, boolean isBotVsPerson) {
        Scanner input = new Scanner(System.in);

        // Initialize players
        TowerGamePlayer player1;
        if (isBotVsPerson) {
            player1 = new TowerGamePlayer("Bot", true);
            System.out.println("Player 1 is a bot name " + player1.getName());
        } else {
            System.out.println("Player 1, please enter your name");
            String name1 = input.next();
            player1 = new TowerGamePlayer(name1, false);
        }

        System.out.println("Player 2, please enter your name");
        String name2 = input.next();
        TowerGamePlayer player2 = new TowerGamePlayer(name2, false);

        // Main game loop
        while (game.getWinner() == -1) {
            game.draw();
            TowerGamePlayer currentPlayer = (game.getCurPlayer() == 1) ? player1 : player2;

            System.out.println(currentPlayer.getName() + ", it's your turn");
            TowersGameMove move = currentPlayer.getNextMove(game);

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