package domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberOfAttemptTest {

    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("시도 횟수를 반환한다")
    void value(final int value) {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(value);

        //when
        int actual = numberOfAttempt.value();

        //then
        assertThat(actual).isEqualTo(value);
    }

    @Test
    @DisplayName("시도 횟수가 0이하의 수라면 예외를 발생시킨다")
    void create_throw_exception_with_zero_or_less_number() {
        //given
        int invalidValue = -1;

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberOfAttempt(invalidValue))
                .withMessageContaining("시도 횟수는 0 이상의 수 입니다");
    }

    @ParameterizedTest
    @CsvSource(value = "2, 1")
    @DisplayName("한 번 시도하면 시도 횟수가 1 차감된다")
    void attempt(final int value, final int expectedValue) {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(value);

        //when
        NumberOfAttempt actual = numberOfAttempt.attempt();
        int actualValue = actual.value();

        //then
        assertThat(actualValue).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"0, true", "1, false"})
    @DisplayName("시도 횟수가 0이면 참 0이상이면 거짓을 반환한다")
    void isOver(final int value, final boolean expected) {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(value);

        //when
        boolean actual = numberOfAttempt.isOver();

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,0,false"})
    @DisplayName("")
    void equals(final int value, final int otherValue, final boolean expected) {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(value);
        NumberOfAttempt other = new NumberOfAttempt(otherValue);

        //when
        boolean actual = numberOfAttempt.equals(other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,true", "1,0,false"})
    @DisplayName("")
    void hash(final int value, final int otherValue, final boolean expected) {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(value);
        NumberOfAttempt other = new NumberOfAttempt(otherValue);

        //when
        boolean actual = numberOfAttempt.hashCode() == other.hashCode();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
