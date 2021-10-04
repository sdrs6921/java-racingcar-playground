package domain.vo;

public class NumberOfAttempt {

    private static final int ZERO = 0;

    private int value;

    public NumberOfAttempt(final int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 수 입니다");
        }

        this.value = value;
    }

    public int value() {
        return value;
    }
}
