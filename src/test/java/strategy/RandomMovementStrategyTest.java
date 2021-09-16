package strategy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovementStrategyTest {

    @ParameterizedTest
    @CsvSource(value = {"true,true", "false,false"})
    void canMove(boolean randomValue, boolean expected) {
        MovementStrategy movementStrategy = new RandomMovementStrategyStrategy() {
            @Override
            protected boolean generateRandom() {
                return randomValue;
            }
        };

        boolean actual = movementStrategy.canMove();

        assertThat(actual).isEqualTo(expected);
    }
}
