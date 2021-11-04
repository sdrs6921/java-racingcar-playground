package dto;

import domain.vo.NumberOfAttempt;

public class InputNumberOfAttemptDto {
    private final int numberOfAttempt;

    public InputNumberOfAttemptDto(final int numberOfAttempt) {
        this.numberOfAttempt = numberOfAttempt;
    }

    public InputNumberOfAttemptDto(final String numberOfAttempt) {
        this(parseFrom(numberOfAttempt));
    }

    private static int parseFrom(final String numberOfAttempt) {
        boolean isNotDigit = numberOfAttempt.chars()
                .anyMatch(num -> !Character.isDigit(num));
        if (isNotDigit) {
            throw new IllegalArgumentException("올바른 시도 횟수가 아닙니다");
        }

        return Integer.parseInt(numberOfAttempt);
    }

    public NumberOfAttempt toNumberOfAttempt() {
        return new NumberOfAttempt(numberOfAttempt);
    }
}
