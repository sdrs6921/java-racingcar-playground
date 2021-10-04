package domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("위치를 초기화 하면 위치값을 반환한다")
    void create() {
        Position position = new Position(1);

        int actual = position.value();

        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("증가할 위치 값을 인자로 받아 위치 값을 증가시킨다")
    void increaseByOne() {
        Position position = new Position(0);

        Position increasedPosition = position.increaseBy(1);
        int actual = increasedPosition.value();

        assertThat(actual).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("위치값이 같으면 참, 다르면 거짓을 반환한다")
    void equals(int value, int otherValue, boolean expected) {
        Position position = new Position(value);
        Position other = new Position(otherValue);

        boolean actual = position.equals(other);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,2,false"})
    @DisplayName("위치값이 같으면 참, 다르면 거짓을 반환한다")
    void hashCode(int value, int otherValue, boolean expected) {
        Position position = new Position(value);
        Position other = new Position(otherValue);

        boolean actual = position.hashCode() == other.hashCode();

        assertThat(actual).isEqualTo(expected);
    }
}
