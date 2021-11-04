package dto;

import domain.Car;
import domain.Cars;

import java.util.List;

public class OutputRoundResultDto {
    private final List<Car> cars;

    public OutputRoundResultDto(final Cars cars) {
        this.cars = cars.elements();
    }

    public List<Car> cars() {
        return cars;
    }
}
