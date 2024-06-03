public class Move {

    private int tower;
    private int cubes;

    public Move(int tower, int cubes) {
        this.tower = tower;
        this.cubes = cubes;
    }

    public int getTower() {
        return tower;
    }

    public void setTower(int tower) {
        this.tower = tower;
    }

    public int getCubes() {
        return cubes;
    }

    public void setCubes(int numOfCubes) {
        this.cubes = numOfCubes;
    }

    @Override
    public String toString() {
        return "[tower=" + tower + ", cubes=" + cubes + "]";
    }
}
