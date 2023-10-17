package org.java2dart.ast.generate.builder;

import org.java2dart.ast.generate.builder.base.BaseTypeCodeBuilder;
import spoon.reflect.declaration.CtField;

public class FieldCodeBuilder extends BaseTypeCodeBuilder {

    protected final CtField field;

    public FieldCodeBuilder(CtField field) {

        super(field, field);
        this.field = field;
    }

    @Override
    public String build() {
        appendModifiers();

        final var type = field.getType();

        final var typeName = type.getSimpleName();
        append(typeName);
        whitespace();

        appendName();
        endline();
        newline();


        return super.build();
    }
}
