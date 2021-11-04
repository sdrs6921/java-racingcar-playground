package domain;

import domain.vo.NumberOfAttempt;
import strategy.MovementStrategy;

import java.util.List;

public class Round {

    private final Cars cars;
    private final NumberOfAttempt numberOfAttempt;

    public Round(final Cars cars, final NumberOfAttempt numberOfAttempt) {
        this.cars = cars;
        this.numberOfAttempt = numberOfAttempt;
    }

    public Round(final Names names, final NumberOfAttempt numberOfAttempt) {
        this(new Cars(names), numberOfAttempt);
    }

    public Round play(final MovementStrategy movementStrategy) {
        NumberOfAttempt numberOfAttemptAfterTrying = numberOfAttempt.decrease();
        Cars carsAfterDriveAll = this.cars.driveAll(movementStrategy);
        return new Round(carsAfterDriveAll, numberOfAttemptAfterTrying);
    }

    public Cars cars() {
        return cars;
    }

    public List<Car> winners() {
        return cars.findMaxPositionCars();
    }

    public boolean isOver() {
        return numberOfAttempt.isOver();
    }
}
