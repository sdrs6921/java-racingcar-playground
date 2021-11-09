package racing.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Names;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputCarNameDtoTest {

    @Test
    @DisplayName("차 이름들을 입력을 받아 차 이름 값 객체들을 반환한다")
    void toNames() {
        //given
        String[] nameElements = new String[]{"name1", "name2", "name3"};
        InputCarNameDto inputCarNameDto = new InputCarNameDto(nameElements);

        //when
        Names names = inputCarNameDto.toNames();

        //then
        assertThat(names).isNotNull();
    }

    @Test
    @DisplayName("이름에 중복이 존재하면 예외를 발생시킨다")
    void create_throw_exception_with_duplicated_name() {
        //given
        String[] nameElements = {"name", "name"};

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> new InputCarNameDto(nameElements))
                .withMessage("중복된 이름이 존재합니다");
    }
}
