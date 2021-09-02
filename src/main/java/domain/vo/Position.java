package domain.vo;

public class Position {

    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Position increaseBy(final int increasedValue) {
        return new Position(value + increasedValue);
    }
}
