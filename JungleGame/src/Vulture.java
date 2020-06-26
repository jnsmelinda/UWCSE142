import java.awt.*;

public class Vulture extends Bird {
    private boolean hungry;

    public Vulture() {
        this.hungry = true;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public Attack fight(String opponent) {
        hungry = true;
        return super.fight(opponent);
    }

    @Override
    public Direction getMove() {
        return super.getMove();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean eat() {
        boolean result = hungry;
        hungry = false;

        return result;
    }
}
