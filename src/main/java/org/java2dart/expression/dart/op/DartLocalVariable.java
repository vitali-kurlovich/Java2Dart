package org.java2dart.expression.dart.op;

import org.java2dart.synthesize.factory.dart.DartDefinitionFactory;
import org.jspecify.annotations.NonNull;
import spoon.reflect.code.CtCatchVariable;
import spoon.reflect.code.CtLocalVariable;

public final class DartLocalVariable {
    private final @NonNull DartDefinitionFactory factory;

    public DartLocalVariable(@NonNull DartDefinitionFactory factory) {
        this.factory = factory;
    }

    public @NonNull String source(CtLocalVariable<?> localVariable) {
        final var builder = new StringBuilder();

        if (localVariable.isFinal()) {
            builder.append("final");
        }

        if (localVariable.isInferred()) {
            if (!localVariable.isFinal()) {
                builder.append("var");
            }
        } else {
            final var typeReference = factory.typeReferenceSpecifier();
            final var type = typeReference.specify(localVariable.getType());

            if (localVariable.isFinal()) {
                builder.append(" ");
            }

            builder.append(type);
        }

        final var name = localVariable.getSimpleName();
        builder.append(" ");
        builder.append(name);

        return builder.toString();
    }



    // CtCatchVariable<T> catchVariable

}
