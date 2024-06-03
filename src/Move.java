public class Move {

    private int tower;
    private int numOfCubes;

    public Move(int tower, int numOfCubes) {
        this.tower = tower;
        this.numOfCubes = numOfCubes;
    }

    public int getTower() {
        return tower;
    }

    public void setTower(int tower) {
        this.tower = tower;
    }

    public int getCubes() {
        return numOfCubes;
    }

    public void setNumOfCubes(int numOfCubes) {
        this.numOfCubes = numOfCubes;
    }

    @Override
    public String toString() {
        return "[tower=" + tower + ", numOfCubes=" + numOfCubes + "]";
    }
}
