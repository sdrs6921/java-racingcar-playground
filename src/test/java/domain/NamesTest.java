package domain;

import domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    @Test
    @DisplayName("이름 객체 리스트를 입력받아 이름 일급 컬렉션을 생성한다")
    void getElements() {
        //given
        List<Name> expected = Arrays.asList(new Name("name1"), new Name("name2"));
        Names names = new Names(expected);

        //when
        List<Name> actual = names.elements();

        //then
        assertThat(actual).isEqualTo(expected);
    }
}
