import java.util.Scanner;

public class TowerGamePlayer {
    private Scanner input;
    private String name;
    private boolean isBot;

    public TowerGamePlayer(String name, boolean isBot) {
        this.input = new Scanner(System.in);
        this.isBot = isBot;
        this.name = name;
    }

    public TowersGameMove getNextMove(TowersGame game) {
        if (isBot) {
            return getBotMove(game);
        } else {
            return getHumanMove(game);
        }
    }

    private TowersGameMove getHumanMove(TowersGame game) {
        System.out.println("Which tower do you want to take cubes from?");
        int whichTower = input.nextInt();
        System.out.println("How many cubes do you want to take?");
        int numOfCubes = input.nextInt();
        return new TowersGameMove(whichTower, numOfCubes);
    }

    private TowersGameMove getBotMove(TowersGame game) {
        if (game.getTower1Cubes() > game.getTower2Cubes())
            return new TowersGameMove(1, game.getTower1Cubes() - game.getTower2Cubes());
        else if (game.getTower2Cubes() > game.getTower1Cubes())
            return new TowersGameMove(2, game.getTower2Cubes() - game.getTower1Cubes());
        else // both towers have same cubes (at least one of them > 0)
            return new TowersGameMove(1, 1);        
    }

    public String getName() {
        return this.name;
    }
}
