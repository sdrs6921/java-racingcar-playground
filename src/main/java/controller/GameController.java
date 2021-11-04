package controller;

import domain.Car;
import domain.Cars;
import domain.Names;
import domain.Round;
import domain.vo.NumberOfAttempt;
import dto.InputCarNameDto;
import dto.InputNumberOfAttemptDto;
import dto.OutputRoundResultDto;
import dto.OutputWinnerDto;
import strategy.MovementStrategy;
import view.InputView;
import view.OutputView;

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

        while (round.isOver()) {
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
