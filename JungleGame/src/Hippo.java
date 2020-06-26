import java.awt.*;
import java.util.Random;

public class Hippo extends Critter {
    private int hunger;
    private int moveCount;
    private Random rand;
    private int direction;

    public Hippo(int hunger) {
        this.hunger = hunger;
        this.moveCount = 0;
        this.rand = new Random();
    }

    @Override
    public Direction getMove() {
        moveCount++;
        if (moveCount % 5 == 1) {
            direction = rand.nextInt(4);
        }
        if (direction == 0) {
            return Direction.NORTH;
        } else if (direction == 1) {
            return Direction.EAST;
        } else if (direction == 2) {
            return Direction.SOUTH;
        } else {
            return Direction.WEST;
        }
    }

    @Override
    public Attack fight(String opponent) {
        return isHungry() ? Attack.SCRATCH : Attack.POUNCE;
    }

    @Override
    public Color getColor() {
        return isHungry() ? Color.GRAY : Color.WHITE;
    }

    @Override
    public boolean eat() {
        boolean currentHungry = isHungry();
        if (currentHungry) {
            hunger--;
        }

        return currentHungry;
    }

    @Override
    public String toString() {
        return String.valueOf(hunger);
    }

    private boolean isHungry() {
        return hunger > 0;
    }
}
