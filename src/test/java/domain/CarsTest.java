package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import strategy.MovementStrategy;
import strategy.RandomMovementStrategyStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CarsTest {

    private Cars cars;

    @Test
    @DisplayName("차 이름들을 인자로 받아 초기화한다")
    void create_with_car_names() {
        String[] carNames = new String[]{"name1", "name2", "name3"};
        cars = new Cars(carNames);
        List<Car> actual = cars.elements();
        assertThat(actual).containsExactly(new Car("name1"), new Car("name2"), new Car("name3"));
    }

    @Test
    @DisplayName("차 요소들로 초기화 한다")
    void create_with_cars() {
        List<Car> elements = Arrays.asList(new Car("name1"), new Car("name2"), new Car("name3"));
        cars = new Cars(elements);
        List<Car> actual = cars.elements();

        assertThat(actual).containsExactly(new Car("name1"), new Car("name2"), new Car("name3"));
    }

    @ParameterizedTest
    @MethodSource(value = "driveAllTestCase")
    @DisplayName("모든 차를 운행시킨다")
    void driveAll(final boolean randomValue, List<Car> expected) {
        List<Car> elements = Arrays.asList(new Car("name1", 1), new Car("name2", 2));
        cars = new Cars(elements);
        MovementStrategy movementStrategy = new RandomMovementStrategyStrategy() {
            @Override
            protected boolean generateRandom() {
                return randomValue;
            }
        };

        cars.driveAll(movementStrategy);

        assertThat(cars.elements()).isEqualTo(expected);
    }

    static Stream<Arguments> driveAllTestCase() {
        return Stream.of(
                arguments(true, Arrays.asList(new Car("name1", 2), new Car("name2", 3))),
                arguments(false, Arrays.asList(new Car("name1", 1), new Car("name2", 2)))
        );
    }

    @Test
    @DisplayName("위치가 가장 높은 차를 반환한다")
    void findMaxPositionCars() {
        List<Car> elements = Arrays.asList(new Car("name1", 2), new Car("name2", 2),
                new Car("name3", 1));
        cars = new Cars(elements);
        List<Car> maxPositionCars = cars.findMaxPositionCars();

        assertThat(maxPositionCars).containsExactly(new Car("name1", 2), new Car("name2", 2));
    }
}
