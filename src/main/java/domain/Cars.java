package domain;

import strategy.MovementStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> elements;

    public Cars(final List<Car> elements) {
        this.elements = elements;
    }

    public Cars(final String[] carNames) {
        this(convertFrom(carNames));
    }

    private static List<Car> convertFrom(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> elements() {
        return elements;
    }

    public void driveAll(final MovementStrategy movementStrategy) {
        elements.forEach(car -> car.move(movementStrategy));
    }

    public List<Car> findMaxPositionCars() {
        int max = findMaxPosition();
        return elements.stream()
                .filter(car -> car.position() == max)
                .collect(Collectors.toUnmodifiableList());
    }

    private int findMaxPosition() {
        return elements.stream()
                .map(Car::position)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("최대값을 찾을 수 없습니다"));
    }
}