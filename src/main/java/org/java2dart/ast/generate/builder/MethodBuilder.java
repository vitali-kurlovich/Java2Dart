package org.java2dart.ast.generate.builder;


import org.java2dart.ast.generate.builder.base.BaseCodeBuilder;
import org.java2dart.ast.generate.builder.base.Builder;
import org.java2dart.ast.generate.builder.base.ModifiableCodeBuilder;
import spoon.reflect.declaration.CtMethod;

public class MethodBuilder extends ModifiableCodeBuilder {

    protected final CtMethod<?> method;

    public MethodBuilder(CtMethod<?> method) {
        super(method);
        this.method = method;
    }

    public String name() {
        return method.getSimpleName();
    }

    public void appendName() {
        append(name());
        whitespace();
    }

    @Override
    public String build() {

        appendModifiers();
        appendName();
        beginBlock();
        newline();
        endBlock();

        return super.build();
    }
}

