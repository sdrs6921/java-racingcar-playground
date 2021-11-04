package racing.view;

import racing.dto.OutputRoundResultDto;
import racing.dto.OutputWinnerDto;

public interface OutputView {
    void printRoundResultMessage();

    void printRoundResult(final OutputRoundResultDto outputRoundResultDto);

    void printWinner(final OutputWinnerDto outputWinnerDto);
}
