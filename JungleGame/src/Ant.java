import java.awt.*;

public class Ant extends Critter {
    private boolean walkSouth;
    private int moveCount;

    public Ant(boolean walkSouth) {
        this.walkSouth = walkSouth;
        this.moveCount = 0;
    }

    @Override
    public Direction getMove() {
        moveCount++;
        if (moveCount % 2 == 1) {
            return walkSouth ? Direction.SOUTH : Direction.NORTH;
        } else {
            return Direction.EAST;
        }
    }

    @Override
    public String toString() {
        return "%";
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public boolean eat() {
        return true;
    }

    @Override
    public Attack fight(String opponent) {
        return Attack.SCRATCH;
    }
}
