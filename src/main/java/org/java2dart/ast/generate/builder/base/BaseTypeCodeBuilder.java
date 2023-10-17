package org.java2dart.ast.generate.builder.base;

import spoon.reflect.declaration.CtModifiable;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypeInformation;
// CtTypeInformation
// CtNamedElement


public class BaseTypeCodeBuilder extends BaseCodeBuilder {

   // protected final CtNamedElement element;
    protected final CtType<?> type;

    public BaseTypeCodeBuilder(CtType<?> type) {

        this.type = type;
    }


    public void  modifiers() {
        final var builder = new ModifiableCodeBuilder(type);
        append(builder);

    }

    public  void name() {
        final var builder = new NamedElementCodeBuilder(type);
        append(builder);
    }










}
