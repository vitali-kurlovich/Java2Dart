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

       var factory = field.getFactory().Code();


       final var modifiableBuilder = new ModifiableCodeBuilder(field);
        append(modifiableBuilder);

       final var typeInfoBuilder =  new TypeInformationCodeBuilder(field.getType());
        append(typeInfoBuilder);

        final var namedBuilder = new NamedElementCodeBuilder(field);
        append(namedBuilder);

        //var bloce = factory.getReferences()

        newline();



        return super.build();
    }
}
