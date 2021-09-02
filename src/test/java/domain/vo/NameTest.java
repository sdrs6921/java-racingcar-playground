package domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"c", "aaaaa"})
    @DisplayName("이름의 길이가 1이상 5이하인 경우 값을 반환한다")
    void name(String value) {
        Name name = new Name(value);

        String actual = name.value();
        
        assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = "aaaaaa")
    @DisplayName("이름의 길이가 0이하, 5초과일 경우 예외가 발생한다")
    void create_throw_exception_with_invalid_name_length(String value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(value))
                .withMessage("이름이 길이는 1이상 5이하여야 합니다");
    }
}
