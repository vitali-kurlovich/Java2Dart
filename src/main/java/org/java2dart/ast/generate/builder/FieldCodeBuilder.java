package org.java2dart.ast.generate.builder;

import org.java2dart.ast.generate.builder.base.*;
import spoon.reflect.declaration.CtField;

public class FieldCodeBuilder extends BaseCodeBuilder {

    protected final CtField field;

    public FieldCodeBuilder(CtField field) {

        this.field = field;
    }

    @Override
    public String build() {

       final var modifiableBuilder = new ModifiableCodeBuilder(field);
        append(modifiableBuilder);

       final var typeInfoBuilder =  new TypeInformationCodeBuilder(field.getType());
        append(typeInfoBuilder);

        final var namedBuilder = new NamedElementCodeBuilder(field);
        append(namedBuilder);
        newline();


        return super.build();
    }
}
