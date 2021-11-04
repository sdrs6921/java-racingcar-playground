package domain;

import domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.MovementStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class CarsTest {

    @Test
    @DisplayName("차 이름들을 인자로 받아 초기화한다")
    void create_with_car_names() {
        //given
        List<Name> names =
                Arrays.asList(new Name("name1"), new Name("name2"), new Name("name3"));
        Names carNames = new Names(names);
        Cars cars = new Cars(carNames);

        //when
        List<Car> actual = cars.elements();

        //then
        assertThat(actual).extracting("name.value", "position.value")
                .containsExactly(
                        tuple("name1", 0),
                        tuple("name2", 0),
                        tuple("name3", 0));
    }

    @Test
    @DisplayName("차 요소들로 초기화 한다")
    void create_with_cars() {
        //given
        List<Car> elements = Arrays.asList(new Car("name1", 1),
                new Car("name2", 2), new Car("name3", 3));
        Cars cars = new Cars(elements);

        //when
        List<Car> actual = cars.elements();

        //then
        assertThat(actual).extracting("name.value", "position.value")
                .containsExactly(
                        tuple("name1", 1),
                        tuple("name2", 2),
                        tuple("name3", 3));
    }

    @ParameterizedTest
    @CsvSource(value = {"true, 2", "false, 1"})
    @DisplayName("모든 차를 운행시킨다")
    void driveAll(final boolean randomValue, final int expectedPosition) {
        //given
        List<Car> elements = List.of(new Car("name1", 1));
        Cars cars = new Cars(elements);
        MovementStrategy movementStrategy = () -> randomValue;

        //when
        Cars droveCars = cars.driveAll(movementStrategy);

        //then
        assertThat(droveCars.elements()).extracting("position.value")
                .containsExactly(expectedPosition);
    }

    @Test
    @DisplayName("위치가 가장 높은 차를 반환한다")
    void findMaxPositionCars() {
        //given
        List<Car> elements = Arrays.asList(new Car("name1", 2), new Car("name2", 2),
                new Car("name3", 1));
        Cars cars = new Cars(elements);

        //when
        List<Car> maxPositionCars = cars.findMaxPositionCars();

        //then
        assertThat(maxPositionCars).extracting("name.value", "position.value")
                .containsExactly(
                        tuple("name1", 2),
                        tuple("name2", 2));
    }
}
