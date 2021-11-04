package racing.controller;

import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Names;
import racing.domain.Round;
import racing.domain.vo.NumberOfAttempt;
import racing.dto.InputCarNameDto;
import racing.dto.InputNumberOfAttemptDto;
import racing.dto.OutputRoundResultDto;
import racing.dto.OutputWinnerDto;
import racing.strategy.MovementStrategy;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final MovementStrategy movementStrategy;

    public GameController(final InputView inputView, final OutputView outputView, final MovementStrategy movementStrategy) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.movementStrategy = movementStrategy;
    }

    public void run() {
        Round round = initRound();
        outputView.printRoundResultMessage();
        round = race(round);
        printWinner(round);
    }

    private Round race(final Round initialRound) {
        Round round = initialRound;

        while (round.isPlaying()) {
            round = round.play(movementStrategy);
            Cars nextRoundCars = round.cars();
            OutputRoundResultDto outputRoundResultDto = new OutputRoundResultDto(nextRoundCars);
            outputView.printRoundResult(outputRoundResultDto);
        }

        return round;
    }

    private Round initRound() {
        InputCarNameDto inputCarNameDto = inputView.inputCarNames();
        InputNumberOfAttemptDto inputNumberOfAttemptDto = inputView.inputNumberOfAttempt();
        Names names = inputCarNameDto.toNames();
        NumberOfAttempt numberOfAttempt = inputNumberOfAttemptDto.toNumberOfAttempt();
        return new Round(names, numberOfAttempt);
    }

    private void printWinner(final Round round) {
        List<Car> winners = round.winners();
        OutputWinnerDto outputWinnerDto = new OutputWinnerDto(winners);
        outputView.printWinner(outputWinnerDto);
    }
}
