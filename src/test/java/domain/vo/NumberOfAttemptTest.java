package domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberOfAttemptTest {
    
    @Test
    @DisplayName("시도 횟수를 반환한다")
    void value() {
        //given
        NumberOfAttempt numberOfAttempt = new NumberOfAttempt(1);

        //when
        int actual = numberOfAttempt.value();

        //then
        assertThat(actual).isEqualTo(1);
    }
    
    @Test
    @DisplayName("시도 횟수가 0이하의 수라면 예외를 발생시킨다")
    void create_throw_exception_with_zero_or_less_number() {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new NumberOfAttempt(0))
                .withMessageContaining("시도 횟수는 1 이상의 수 입니다");
    }
}
