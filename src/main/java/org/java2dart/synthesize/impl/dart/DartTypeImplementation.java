package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.TypeImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;

public class DartTypeImplementation implements TypeImplementation {

    private final @NonNull DartDefinitionFactory factory = new DartDefinitionFactory();

    @Override
    public @NonNull String source(CtType<?> type) {


        final var builder = new StringBuilder();

        final var typeDefinition = factory.typeDefinitionSpecifier();

        builder.append(typeDefinition.specify(type))
                .append(" {\n");

        builder.append("}");


        return builder.toString().trim();
    }


}
