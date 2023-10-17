package org.java2dart.ast.generate.builder.base;

import spoon.reflect.declaration.CtNamedElement;


// CtTypeInformation

public class NamedElementCodeBuilder extends BaseCodeBuilder {
    protected final CtNamedElement element;

    public NamedElementCodeBuilder(CtNamedElement element) {
        this.element = element;
    }

    public String getSimpleName() {
        return element.getSimpleName();
    }

    void appendName() {
        append(getSimpleName());
    }

    @Override
    public String build() {
        appendName();
        return super.build();
    }
}
