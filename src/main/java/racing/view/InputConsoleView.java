package racing.view;

import racing.dto.InputCarNameDto;
import racing.dto.InputNumberOfAttemptDto;

import java.util.Scanner;

import static java.lang.System.out;

public class InputConsoleView implements InputView {

    private static final String NAME_TOKEN_DELIMITER = "\\s*,\\s*";
    private final Scanner scanner;

    public InputConsoleView(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public InputCarNameDto inputCarNames() {
        out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameToken = scanner.nextLine();
        String[] names = nameToken.split(NAME_TOKEN_DELIMITER);
        return new InputCarNameDto(names);
    }

    @Override
    public InputNumberOfAttemptDto inputNumberOfAttempt() {
        out.println("시도할 회수는 몇회인가요?");
        String numberValue = scanner.nextLine();
        return new InputNumberOfAttemptDto(numberValue);
    }
}