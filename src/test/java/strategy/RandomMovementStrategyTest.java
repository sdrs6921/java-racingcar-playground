package strategy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"true,true", "false,false"})
    void canMove(boolean randomValue, boolean expected) {
        //given
        MovementStrategy movementStrategy = new RandomMovementStrategyStrategy() {
            @Override
            protected boolean generateRandom() {
                return randomValue;
            }
        };

        //when
        boolean actual = movementStrategy.canMove();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
