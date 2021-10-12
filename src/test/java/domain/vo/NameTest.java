package domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"c", "aaaaa"})
    @DisplayName("이름의 길이가 1이상 5이하인 경우 값을 반환한다")
    void name(String value) {
        //given
        Name name = new Name(value);

        //when
        String actual = name.value();

        //then
        assertThat(actual).isEqualTo(value);
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = "aaaaaa")
    @DisplayName("이름의 길이가 0이하, 5초과일 경우 예외가 발생한다")
    void create_throw_exception_with_invalid_name_length(String value) {
        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new Name(value))
                .withMessage("이름이 길이는 1이상 5이하여야 합니다");
    }

    @ParameterizedTest
    @CsvSource(value = {"name,name,true", "name,other,false"})
    @DisplayName("이름이 같으면 참을 다르면 거짓을 반환한다")
    void equals(String value, String otherValue, boolean expected) {
        //given
        Name name = new Name(value);
        Name other = new Name(otherValue);

        //when
        boolean actual = name.equals(other);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"name,name,true", "name,other,false"})
    @DisplayName("이름이 같으면 같은 해시값을 반환하고, 다르면 다른 해시값을 반환한다")
    void hashCode(String value, String otherValue, boolean expected) {
        //given
        Name name = new Name(value);
        Name other = new Name(otherValue);

        //when
        boolean actual = name.hashCode() == other.hashCode();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
