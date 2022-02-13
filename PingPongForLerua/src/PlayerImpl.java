import java.util.Random;

public class PlayerImpl implements Player{
    private Random random = new Random();
    private int countPoints = 0;
    private int id;

    public PlayerImpl(int id) {
        this.id = id;
    }

    @Override
    public int hit(int[][] table) {
        int xSize = table[0].length;
        int ySize = table.length;
        return random.nextInt(xSize * ySize);
    }

    public int getCountPoints() {
        return this.countPoints;
    }

    public void setCountPoints(int countPoints) {
        this.countPoints = countPoints;
    }

    @Override
    public void addPoint() {
        this.countPoints = this.countPoints + 1;
    }

    public int getId() {
        return id;
    }
}
