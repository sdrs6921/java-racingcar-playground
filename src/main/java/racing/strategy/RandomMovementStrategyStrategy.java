package racing.strategy;

import java.util.Random;

public class RandomMovementStrategyStrategy implements MovementStrategy {

    private final Random random = new Random();

    @Override
    public boolean canMove() {
        return generateRandom();
    }

    protected boolean generateRandom() {
        return random.nextBoolean();
    }
}
