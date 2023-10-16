package org.java2dart.ast.generate.builder;

import org.java2dart.ast.generate.builder.base.BaseTypeCodeBuilder;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;

public class FieldCodeBuilder extends BaseTypeCodeBuilder {

    protected final CtField field;

    public FieldCodeBuilder(CtField field) {

        super(field, field);
        this.field = field;
    }

    @Override
    public String build() {
        appendTypeProperty();

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
