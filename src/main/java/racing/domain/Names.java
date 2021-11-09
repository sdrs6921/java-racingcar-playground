package racing.domain;

import racing.domain.vo.Name;

import java.util.List;

public class Names {

    private final List<Name> elements;

    public Names(final List<Name> elements) {
        this.elements = elements;
    }

    public List<Name> elements() {
        return elements;
    }
}
