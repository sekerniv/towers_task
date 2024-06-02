import java.util.Random;

public class TowersGame {
    private static int maxCubes = 10;
    int curPlayer;

    // We're only doing 2 towers for now, because it's annoying to implement without knowing "arrays"
    private int tower1Cubes;
    private int tower2Cubes;

    private final int numOfTowers;

    public TowersGame(int numOfTowers) {
        this.curPlayer = 1;
        this.numOfTowers = numOfTowers;
        Random rnd = new Random();
        this.tower1Cubes = rnd.nextInt(maxCubes + 1);
        
        if (this.numOfTowers > 1) {
            this.tower2Cubes = rnd.nextInt(maxCubes + 1);
        } else {
            this.tower2Cubes = 1;
        }
    }

    public TowersGame(int tower1Cubes, int tower2Cubes) {
        curPlayer = 1;
        this.numOfTowers = 2;
        this.tower1Cubes = tower1Cubes;
        this.tower2Cubes = tower2Cubes;
    }

    public int getCurPlayer() {
        return curPlayer;
    }

    /**
     * Will only pass the turn if the game is not over
     * @param towerFrom
     * @param numOfCubes
     * @return
     */
    public boolean play(TowersGameMove move) {
        if (move.getTower() < 1 || this.numOfTowers < move.getTower() || move.getCubes() < 1) {
            return false;
        }
        
        if (move.getTower() == 1) {
            if (move.getCubes() > tower1Cubes) {
                return false;
            } else {
                playValidMove(move);
                return true;
            }
        } else if (move.getTower() == 2) {
            if (move.getCubes() > tower2Cubes) {
                return false;
            } else {
                playValidMove(move);
                return true;
            }
        } else {
            return false;
        }
    }

    private void playValidMove(TowersGameMove move){
        if (move.getTower() == 1) {
            tower1Cubes -= move.getCubes();
        } else {
            tower2Cubes -= move.getCubes();
        }
        if(getWinner() == -1) {
            swapPlayer();
        }
    }

    private void swapPlayer(){
        if(this.curPlayer == 1){
            this.curPlayer = 2;
        } else {
            this.curPlayer = 1;
        }
    }

    public void draw() {
        int maxHeight = Math.max(tower1Cubes, tower2Cubes);
        for (int i = maxHeight; i > 0; i--) {
            if (tower1Cubes >= i) {
                System.out.print("*     ");
            } else {
                System.out.print("      ");
            }
            if (tower2Cubes >= i) {
                System.out.print("*");
            } else {
                System.out.print("   ");
            }
            System.out.println();
        }
        if (this.numOfTowers == 1) {
            System.out.println(this.tower1Cubes);
            System.out.println("T1");
        } else {
            System.out.println("T1" + "    " + "T2");
            System.out.println(tower1Cubes + "     " + tower2Cubes);
        }
    }
    
    /**
     *  
     * @return -1 if there is no winner yet, 0 if the game is a draw, 1 if player 1 wins, 2 if player 2 wins
     */
    public int getWinner() {
        if(this.tower1Cubes == 0 && this.tower2Cubes == 0) {
            return this.curPlayer;
        } else {
            return -1;
        }
    }
    
    public int getTower1Cubes() {
        return tower1Cubes;
    }

    public int getTower2Cubes() {
        return tower2Cubes;
    }

    public int getNumOfTowers() {
        return numOfTowers;
    }
}