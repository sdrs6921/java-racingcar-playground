package view;

import domain.Car;
import dto.OutputRoundResultDto;
import dto.OutputWinnerDto;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

import static java.lang.System.out;

public class OutputConsoleView implements OutputView {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String WINNER_NAME_DELIMITER = ", ";

    @Override
    public void printRoundResultMessage() {
        out.println();
        out.println("실행결과");
    }

    @Override
    public void printRoundResult(final OutputRoundResultDto outputRoundResultDto) {
        List<Car> cars = outputRoundResultDto.cars();
        cars.forEach(car -> out.println(car.name() + getDistanceSymbols(car.position())));
        out.println();
    }

    private String getDistanceSymbols(final int position) {
        StringBuilder distanceSymbols = new StringBuilder();
        IntStream.range(0, position)
                .forEach(index -> distanceSymbols.append(DISTANCE_SYMBOL));
        return distanceSymbols.toString();
    }

    @Override
    public void printWinner(final OutputWinnerDto outputWinnerDto) {
        List<String> winners = outputWinnerDto.winners();
        String winnerName = convertWinnerNameFrom(winners);
        out.println(winnerName + "가 최종 우승했습니다.");
    }

    private String convertWinnerNameFrom(final List<String> winners) {
        StringJoiner winnerName = new StringJoiner(WINNER_NAME_DELIMITER);
        winners.forEach(winnerName::add);
        return winnerName.toString();
    }
}
