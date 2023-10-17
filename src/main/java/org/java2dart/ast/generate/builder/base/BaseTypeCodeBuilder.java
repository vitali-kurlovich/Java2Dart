package org.java2dart.ast.generate.builder.base;

import spoon.reflect.declaration.CtModifiable;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtType;
// CtTypeInformation
// CtNamedElement




public class BaseTypeCodeBuilder extends ModifiableCodeBuilder {

    protected final CtNamedElement element;

    public BaseTypeCodeBuilder(CtType<?> type) {
        this(type, type);
    }

    public BaseTypeCodeBuilder(CtModifiable modifiable, CtNamedElement element) {
        //this.modifiable = modifiable;
        super(modifiable);
        this.element = element;
    }

    public String name() {
        return  element.getSimpleName();
    }

    public void appendName() {
        append(name());
        whitespace();
    }








}
