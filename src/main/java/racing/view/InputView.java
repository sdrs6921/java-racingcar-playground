package racing.view;

import racing.dto.InputCarNameDto;
import racing.dto.InputNumberOfAttemptDto;

public interface InputView {

    InputCarNameDto inputCarNames();

    InputNumberOfAttemptDto inputNumberOfAttempt();
}
