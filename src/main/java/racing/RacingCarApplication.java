package racing;

import racing.controller.GameController;
import racing.strategy.MovementStrategy;
import racing.strategy.RandomMovementStrategyStrategy;
import racing.view.InputConsoleView;
import racing.view.InputView;
import racing.view.OutputConsoleView;
import racing.view.OutputView;

import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputConsoleView(scanner);
        OutputView outputView = new OutputConsoleView();
        MovementStrategy movementStrategy = new RandomMovementStrategyStrategy();
        GameController gameController = new GameController(inputView, outputView, movementStrategy);
        gameController.run();
        scanner.close();
    }
}
