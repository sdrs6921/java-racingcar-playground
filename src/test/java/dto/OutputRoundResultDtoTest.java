package dto;

import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class OutputRoundResultDtoTest {

    @Test
    @DisplayName("차 일급컬렉션을 입력받아 차 리스트를 반환한다")
    void cars() {
        //given
        Car car1 = new Car("name1", 1);
        Car car2 = new Car("name2", 2);
        List<Car> elements = Arrays.asList(car1, car2);

        Cars cars = new Cars(elements);

        OutputRoundResultDto outputRoundResultDto = new OutputRoundResultDto(cars);

        //when
        List<Car> actual = outputRoundResultDto.cars();

        //then
        assertThat(actual).extracting("name.value", "position.value")
                .containsExactly(
                        tuple("name1", 1),
                        tuple("name2", 2)
                );
    }
}
