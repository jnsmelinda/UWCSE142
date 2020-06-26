import java.awt.*;
import java.util.Random;

public class Husky extends Critter {
    public static final Color PURPLE = new Color(150, 0, 150);
    public static final Color GOLD = new Color(255, 215, 0);
    private Random random;
    private Color color;
    int moveCount;

    public Husky() {
        this.random = new Random();
        this.color = PURPLE;
    }

    @Override
    public String toString() {
        return "H";
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Direction getMove() {
        moveCount++;
        if (moveCount % 25 == 0) {
            return Direction.SOUTH;
        } else {
            return Direction.EAST;
        }
//        int direction = random.nextInt(4);
//        if (direction == 0) {
//            return Direction.NORTH;
//        }
//        else if (direction == 1) {
//            return Direction.EAST;
//        }
//        else if (direction == 2) {
//            return Direction.SOUTH;
//        }
//        else {
//            return Direction.WEST;
//        }
    }

    @Override
    public Attack fight(String opponent) {
        color = GOLD;
        Attack attack;
        if ("%".equals(opponent)) {
            attack = Attack.ROAR;
        }
        else if ("<".equals(opponent) || ">".equals(opponent) || "^".equals(opponent) || "V".equals(opponent)) {
            attack = Attack.SCRATCH;
        }
        else if ("S".equals(opponent)) {
            attack = Attack.POUNCE;
        }
        else {
            Integer hippoInt = Integer.parseInt(opponent);
            if (hippoInt > 0) {
                attack = Attack.ROAR;
            }
            else {
                attack = Attack.SCRATCH;
            }
        }
        return attack;
    }

    @Override
    public boolean eat() {
        color = PURPLE;
        return true;
    }
}
