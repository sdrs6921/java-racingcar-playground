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

    private static List<String> parseFrom(final String[] names) {
        return Arrays.stream(names)
                .collect(Collectors.toList());
    }

    public Names toNames() {
        List<Name> elements = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
        return new Names(elements);
    }
}
