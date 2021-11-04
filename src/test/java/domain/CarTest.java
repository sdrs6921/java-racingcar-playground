package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.MovementStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("name");
    }

    @Test
    @DisplayName("이름를 입력받아 자동차 생성해서 이름과 초기 위치를 반환한다")
    void create() {
        //given
        String name = car.name();
        int position = car.position();

        //then
        assertAll(
                () -> assertThat(name).isEqualTo("name"),
                () -> assertThat(position).isZero()
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    @DisplayName("차의 위치를 증가시킨다")
    void move(boolean randomValue, int expected) {
        //given
        MovementStrategy movementStrategy = () -> randomValue;
        Car actualCar = car.move(movementStrategy);

        //when
        int actual = actualCar.position();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"name,name,true", "name,other,false"})
    @DisplayName("차의 이름이 같으면 참, 다른 이름일 경우 거짓을 반환한다")
    void equals(String name, String otherName, boolean expected) {
        //given
        Car car = new Car(name);
        Car other = new Car(otherName);

        //when
        boolean actual = car.equals(other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"name,name,true", "name,other,false"})
    @DisplayName("차의 이름이 같으면 참, 다른 이름일 경우 거짓을 반환한다")
    void hash(String name, String otherName, boolean expected) {
        //given
        Car car = new Car(name);
        Car other = new Car(otherName);

        //when
        boolean actual = car.hashCode() == other.hashCode();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
