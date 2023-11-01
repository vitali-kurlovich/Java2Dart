package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.method.MethodImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtMethod;

public final class DartMethodImplementation implements MethodImplementation {

    private final @NonNull DartDefinitionFactory factory;

    private final DartVisitableImplementation statementImpl ;

    public DartMethodImplementation(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
        statementImpl = new DartVisitableImplementation(factory);
    }

    @Override
    public @NonNull String source(CtMethod<?> method) {
        final var methodDefinition = factory.methodDefinitionSpecifier();

        final var builder = new StringBuilder();
        builder.append(methodDefinition.specify(method));

        final var body = method.getBody();

        if (body == null) {
            builder.append(";\n");

        } else {
            builder.append(" ");
            final var source = statementImpl.source(body);
            builder.append(source);

        }

        return builder.toString().trim();
    }
}
