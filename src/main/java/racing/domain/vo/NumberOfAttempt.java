package racing.domain.vo;

import java.util.Objects;

public class NumberOfAttempt {

    private static final int ZERO = 0;
    private static final int SUBTRACTED_VALUE = 1;

    private final int value;

    public NumberOfAttempt(final int value) {
        if (value < ZERO) {
            throw new IllegalArgumentException("시도 횟수는 0 이상의 수 입니다");
        }

        this.value = value;
    }

    public int value() {
        return value;
    }

    public NumberOfAttempt decrease() {
        return new NumberOfAttempt(value - SUBTRACTED_VALUE);
    }

    public boolean isOver() {
        return value == ZERO;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberOfAttempt)) return false;
        final NumberOfAttempt that = (NumberOfAttempt) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
