package domain;

import domain.vo.Name;
import domain.vo.Position;

public class Car {

    private static final int INITIAL_LOCATION = 0;
    private static final int DISTANCE_MOVED_AT_ONCE = 1;

    private final Name name;
    private Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position(INITIAL_LOCATION);
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position.value();
    }

    public void move(boolean canMove) {
        if (canMove) {
            position = position.increaseBy(DISTANCE_MOVED_AT_ONCE);
        }
    }
}
