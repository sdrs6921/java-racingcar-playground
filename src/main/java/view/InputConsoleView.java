package view;

import java.util.Scanner;

public class InputConsoleView implements InputView {

    private final Scanner scanner;

    public InputConsoleView(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String nameToken = scanner.nextLine();
        return nameToken.split(",");
    }

    @Override
    public int inputNumberOfAttempt() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(scanner.nextLine());
    }
}
