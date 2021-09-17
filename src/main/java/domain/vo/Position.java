package domain.vo;

import java.util.Objects;

public class Position {

    private final int value;

    public Position(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    public Position increaseBy(final int distanceMovedAtOnce) {
        return new Position(value + distanceMovedAtOnce);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isLargerThan(final Position other) {
        return value() > other.value();
    }
}
