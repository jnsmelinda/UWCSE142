import java.awt.*;

public class Bird extends Critter {
    private int moveCount;

    public Bird() {
        this.moveCount = 0;
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    public boolean eat() {
        return false;
    }

    @Override
    public Attack fight(String opponent) {
        if ("%".equals(opponent)) {
            return Attack.ROAR;
        }

        return Attack.POUNCE;
    }

    @Override
    public Direction getMove() {
        moveCount++;
        return getCurrentDirection();
    }

    @Override
    public String toString() {
        String result = null;
        switch (getCurrentDirection()) {
            case CENTER:
            case NORTH:
                result = "^";
                break;
            case EAST:
                result = ">";
                break;
            case SOUTH:
                result = "V";
                break;
            case WEST:
                result = "<";
                break;
        }

        return result;
    }

    private Direction getCurrentDirection() {
        Direction direction = null;

        if (moveCount == 0) {
            direction = Direction.CENTER;
        }
        else {
            switch ((moveCount - 1) % 12) {
                case 0:
                case 1:
                case 2:
                    direction = Direction.NORTH;
                    break;
                case 3:
                case 4:
                case 5:
                    direction = Direction.EAST;
                    break;
                case 6:
                case 7:
                case 8:
                    direction = Direction.SOUTH;
                    break;
                case 9:
                case 10:
                case 11:
                    direction = Direction.WEST;
                    break;
            }
        }

        return direction;
    }
}
