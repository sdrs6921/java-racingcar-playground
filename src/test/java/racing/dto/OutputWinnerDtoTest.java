package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputWinnerDtoTest {

    @Test
    @DisplayName("우승자들을 이름으로 받아 우승자들의 이름을 반환한다")
    void winners() {
        //given
        List<Car> winners = Arrays.asList(new Car("name1"), new Car("name2"));
        OutputWinnerDto outputWinnerDto = new OutputWinnerDto(winners);

        //when
        List<String> actual = outputWinnerDto.winners();

        //then
        assertThat(actual).containsExactly("name1", "name2");
    }
}
