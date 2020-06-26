import java.awt.*;

public class Sloth extends Critter {
    private int couldHaveEaten;
    private int moveCount;

    // return the color the sloth should appear (always cyan)
    public Color getColor() {
        return Color.CYAN;
    }

    // returns whether or not the sloth should eat (never)
    // also tracks how many times the sloth had the option to eat
    public boolean eat() {
        couldHaveEaten++;
        return super.eat();
    }

    // returns the string representation of the sloth
    //   (the number of times it could have eaten)
    public String toString() {
        return "" + couldHaveEaten;
    }

    // returns the direction the sloth should move
    //   (west every third move, center otherwise)
    public Direction getMove() {
        moveCount++;
        if (moveCount % 3 == 0) {
            return Direction.WEST;
        } else {
            return Direction.CENTER;
        }
    }
}
