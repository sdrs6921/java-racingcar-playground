package dto;

import domain.Names;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputCarNameDtoTest {

    @Test
    @DisplayName("차 이름들로 입력을 받아 차 이름 값 객체들을 반환한다")
    void toNames() {
        //given
        String[] nameElements = new String[]{"name1", "name2", "name3"};
        InputCarNameDto inputCarNameDto = new InputCarNameDto(nameElements);

        //when
        Names names = inputCarNameDto.toNames();

        //then
        assertThat(names).isNotNull();
    }
}
