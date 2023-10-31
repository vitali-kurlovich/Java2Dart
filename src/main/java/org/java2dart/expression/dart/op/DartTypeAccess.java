package org.java2dart.expression.dart.op;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.jspecify.annotations.NonNull;
import spoon.reflect.code.CtTypeAccess;

public final class DartTypeAccess {
    private final @NonNull DartDefinitionFactory factory;

    public DartTypeAccess(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
    }

    public @NonNull String source(CtTypeAccess<?> typeAccess) {
        final var typeReference = factory.typeReferenceSpecifier();
        return typeReference.specify(typeAccess.getAccessedType());
    }
}
