package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.field.FieldImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;

public final class DartFieldImplementation implements FieldImplementation {
   private final @NonNull DartDefinitionFactory factory;

    public DartFieldImplementation(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
    }

    @Override
    public @NonNull String source(CtField<?> field) {
        final var fieldDefinition = factory.fieldDefinitionSpecifier();
        return fieldDefinition.specify(field);
    }
}
