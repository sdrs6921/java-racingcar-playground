package domain;

import domain.vo.Name;

import java.util.List;

public class Names {

    private List<Name> elements;

    public Names(final List<Name> elements) {
        this.elements = elements;
    }

    public List<Name> getElements() {
        return elements;
    }
}
