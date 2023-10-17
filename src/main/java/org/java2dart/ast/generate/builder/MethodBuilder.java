package org.java2dart.ast.generate.builder;


import org.java2dart.ast.generate.builder.base.*;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtParameter;

import java.util.List;

public class MethodBuilder extends BaseCodeBuilder {
    protected final CtMethod<?> method;

    public MethodBuilder(CtMethod<?> method) {

        this.method = method;
    }



    public List<CtParameter<?>> parameters() {
        return method.getParameters();
    }



    @Override
    public String build() {

        final var modifiableBuilder = new ModifiableCodeBuilder(method);
        append(modifiableBuilder);



        final var typeInfoBuilder =  new TypeInformationCodeBuilder(method.getType());
        append(typeInfoBuilder);


        final var namedBuilder = new NamedElementCodeBuilder(method);
        append(namedBuilder);

        beginBlock();
        newline();
        endBlock();

        return super.build();
    }
}

