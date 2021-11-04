package view;

import dto.OutputRoundResultDto;
import dto.OutputWinnerDto;

public interface OutputView {
    void printRoundResultMessage();

    void printRoundResult(final OutputRoundResultDto outputRoundResultDto);

    void printWinner(final OutputWinnerDto outputWinnerDto);
}
