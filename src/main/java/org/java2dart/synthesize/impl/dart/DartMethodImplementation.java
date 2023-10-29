package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.method.MethodImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtMethod;

public final class DartMethodImplementation implements MethodImplementation {

    private final @NonNull DartDefinitionFactory factory;

    public DartMethodImplementation(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
    }

    @Override
    public @NonNull String source(CtMethod<?> method) {
        final var methodDefinition = factory.methodDefinitionSpecifier();

        final var builder = new StringBuilder();
        builder.append(methodDefinition.specify(method));

        if (method.isAbstract()) {
            builder.append(";\n");
        } else {
            builder.append(" {\n");
            builder.append("}\n");
        }

        return builder.toString().trim();
    }
}
