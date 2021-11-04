package racing.dto;

import racing.domain.Car;
import racing.domain.Cars;

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
