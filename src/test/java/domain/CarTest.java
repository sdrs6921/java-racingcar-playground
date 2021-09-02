package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        String name = car.name();
        int position = car.position();

        assertAll(
                () -> assertThat(name).isEqualTo("name"),
                () -> assertThat(position).isZero()
        );
    }
    
    @ParameterizedTest
    @CsvSource(value = {"true,1", "false,0"})
    @DisplayName("차의 위치를 증가시킨다")
    void move(boolean canMove, int expected) {
        car.move(canMove);
        int actual = car.position();

        assertThat(actual).isEqualTo(expected);
    }
}
