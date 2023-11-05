package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtMethod;

public final class DartMethodDefinitionSpecifier implements MethodDefinitionSpecifier {

    private final @NonNull DartModifiersDefinitionSpecifier modifiersSpecifier;
    private final @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier;
    private final @NonNull DartParameterDefinitionSpecifier parameterDefinitionSpecifier;

    public DartMethodDefinitionSpecifier(@NonNull DartModifiersDefinitionSpecifier modifiersSpecifier,
                                         @NonNull DartTypeReferenceSpecifier typeSpecifier,
                                         @NonNull DartParameterDefinitionSpecifier parameterDefinitionSpecifier) {
        this.modifiersSpecifier = modifiersSpecifier;
        this.typeReferenceSpecifier = typeSpecifier;
        this.parameterDefinitionSpecifier = parameterDefinitionSpecifier;
    }

    @Override
    public @NonNull String specify(CtMethod<?> method) {
        final var builder = new StringBuilder();

        final var returnType = typeReferenceSpecifier.specify(method.getType());

        builder.append(modifiersSpecifier.specify(method))
                .append(" ")
                .append(returnType)
                .append(" ")
                .append(method.getSimpleName())
                .append("(");

        var neesdsSeparator = false;
        for (final var param : method.getParameters()) {
            if (neesdsSeparator) {
                builder.append(", ");
            }

            final var spec = parameterDefinitionSpecifier.specify(param);
            builder.append(spec);
            neesdsSeparator = true;
        }

        builder.append(")");

        return builder.toString();
    }


}
