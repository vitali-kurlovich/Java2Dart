package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.java2dart.synthesize.impl.TypeImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;

public class DartTypeImplementation implements TypeImplementation {
    private final @NonNull DartDefinitionFactory factory = new DartDefinitionFactory();

    private final @NonNull DartFieldImplementation dartFieldImpl = new DartFieldImplementation(this.factory);
    private final @NonNull DartMethodImplementation dartMethodImpl = new DartMethodImplementation(this.factory);

    @Override
    public @NonNull String source(CtType<?> type) {

        final var builder = new StringBuilder();

        final var typeDefinition = factory.typeDefinitionSpecifier();

        builder.append(typeDefinition.specify(type))
                .append(" {\n");

        final var fields = type.getFields();

        for (final var field : fields) {
            final var source = dartFieldImpl.source(field);
            builder.append(source).append(";\n");
        }

        builder.append("\n");

        final var methods = type.getMethods();

        for (final var method : methods) {
            final var source = dartMethodImpl.source(method);
            builder.append(source).append("\n");
        }

        builder.append("}\n");

        return builder.toString().trim();
    }

}
