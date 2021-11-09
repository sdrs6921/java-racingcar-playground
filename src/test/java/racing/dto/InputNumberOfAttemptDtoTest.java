package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.vo.NumberOfAttempt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputNumberOfAttemptDtoTest {

    @Test
    @DisplayName("시도 횟수를 인자로 받아 값을 반환한다")
    void getNumberOfAttempt() {
        //given
        int expected = 3;
        InputNumberOfAttemptDto inputNumberOfAttemptDto = new InputNumberOfAttemptDto(expected);

        //when
        NumberOfAttempt actual = inputNumberOfAttemptDto.toNumberOfAttempt();

        //then
        assertThat(actual).extracting("value")
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("시도 횟수가 숫자가 아닐 경우 예외를 발생시킨다")
    void create_throw_exception_with_not_digit() {
        //given
        String invalidNumberOfAttempt = "String";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new InputNumberOfAttemptDto(invalidNumberOfAttempt))
                .withMessageContaining("올바른 시도 횟수가 아닙니다");
    }
}
