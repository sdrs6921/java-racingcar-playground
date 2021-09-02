package domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
