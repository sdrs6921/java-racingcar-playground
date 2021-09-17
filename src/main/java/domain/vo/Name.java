package domain.vo;

import java.util.Objects;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String value;

    public Name(final String value) {
        validate(value);
        this.value = value;
    }

    private void validate(final String value) {
        if (value.length() < MIN_NAME_LENGTH || value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 길이는 1이상 5이하여야 합니다");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) return true;
        if (!(other instanceof Name)) return false;
        final Name name = (Name) other;
        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
