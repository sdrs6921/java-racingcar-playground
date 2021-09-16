package domain;

import domain.vo.Name;
import domain.vo.Position;
import strategy.MovementStrategy;

public class Car {

    private static final int INITIAL_LOCATION = 0;
    private static final int DISTANCE_MOVED_AT_ONCE = 1;

    private final Name name;
    private final Position position;

    public Car(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(final String name, final int position) {
        this(new Name(name), new Position(position));
    }

    public Car(final String name) {
        this(name, INITIAL_LOCATION);
    }

    public String name() {
        return name.value();
    }

    public int position() {
        return position.value();
    }

    public Car move(MovementStrategy movementStrategy) {
        if (movementStrategy.canMove()) {
            return new Car(name, position.increaseBy(DISTANCE_MOVED_AT_ONCE));
        }

        return this;
    }
}
