package dto;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputWinnerDto {
    private final List<String> winners;

    public OutputWinnerDto(final List<Car> winners) {
        this.winners = convertFrom(winners);
    }

    private List<String> convertFrom(final List<Car> winners) {
        return winners.stream()
                .map(Car::name)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<String> winners() {
        return winners;
    }
}
