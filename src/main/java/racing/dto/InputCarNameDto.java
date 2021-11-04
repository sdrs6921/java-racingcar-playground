package racing.dto;

import racing.domain.Names;
import racing.domain.vo.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputCarNameDto {
    private final List<String> names;

    public InputCarNameDto(final List<String> names) {
        this.names = names;
    }

    public InputCarNameDto(final String[] names) {
        this(parseFrom(names));
    }

    private static List<String> parseFrom(final String[] carNames) {
        List<String> names = Arrays.stream(carNames)
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        validateDuplicatedName(carNames, names);
        return names;
    }

    private static void validateDuplicatedName(final String[] carNames, final List<String> names) {
        if (names.size() < carNames.length) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다");
        }
    }

    public Names toNames() {
        List<Name> elements = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
        return new Names(elements);
    }
}
