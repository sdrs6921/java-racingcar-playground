package domain;

import domain.vo.NumberOfAttempt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.MovementStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertAll;

class RoundTest {

    @Test
    @DisplayName("시도 횟수와 차들을 인자로 받아 한 라운드를 생성한다")
    void create() {
        //given
        int value = 1;
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(value);
        List<Car> elements = Arrays.asList(new Car("name1"), new Car("name2"));
        Cars cars = new Cars(elements);

        //when
        Round round = new Round(cars, numberOfAttempt);

        //then
        assertAll(
                () -> assertThat(round).extracting("cars.elements").isEqualTo(elements),
                () -> assertThat(round).extracting("numberOfAttempt.value").isEqualTo(value)
        );

    }

    @Test
    @DisplayName("움직이는 전략을 인자로 받아 한 라운드를 수행하고 움직인 차들과 시도 횟수가 차감된 새로운 라운드를 반환한다.")
    void play() {
        //given
        int numberOfAttemptValue = 2;
        int expectedNumberOfAttemptValue = numberOfAttemptValue - 1;
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(numberOfAttemptValue);

        List<Car> carsElements = Arrays.asList(new Car("name1"), new Car("name2"));
        Cars cars = new Cars(carsElements);

        Round round = new Round(cars, numberOfAttempt);

        MovementStrategy movementStrategy = () -> true;

        //when
        Round actual = round.play(movementStrategy);
        Cars actualCars = actual.cars();
        List<Car> actualCarsElements = actualCars.elements();

        //then
        assertAll(
                () -> assertThat(actualCarsElements).extracting("name.value", "position.value")
                        .containsExactly(
                                tuple("name1", 1),
                                tuple("name2", 1)),
                () -> assertThat(actual).extracting("numberOfAttempt.value")
                        .isEqualTo(expectedNumberOfAttemptValue)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"0, true", "1, false"})
    @DisplayName("시도 횟수가 없으면 참 아니면 거짓을 반환한다")
    void isOver(final int numberOfAttemptValue, final boolean expected) {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(numberOfAttemptValue);

        List<Car> elements = Arrays.asList(new Car("name1"), new Car("name2"));
        Cars cars = new Cars(elements);

        Round round = new Round(cars, numberOfAttempt);

        //when
        boolean actual = round.isOver();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("차들을 반환한다")
    void cars() {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(1);
        List<Car> elements = Arrays.asList(new Car("name1"), new Car("name2"));
        Cars cars = new Cars(elements);

        Round round = new Round(cars, numberOfAttempt);

        //when
        Cars actual = round.cars();

        //then
        assertThat(actual).isEqualTo(cars);
    }

    @Test
    @DisplayName("우승자를 반환한다")
    void winners() {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(1);
        Car winner1 = new Car("winner1", 3);
        Car winner2 = new Car("winner2", 3);
        Car loser = new Car("loser", 2);
        List<Car> elements = Arrays.asList(winner1, winner2, loser);
        Cars cars = new Cars(elements);

        Round round = new Round(cars, numberOfAttempt);

        //when
        List<Car> winners = round.winners();

        //then
        assertThat(winners).extracting("name", "position")
                .containsExactly(
                        tuple("winner1", 3),
                        tuple("winner2", 3)
                );
    }
}
