package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.varible.ParameterDefinitionSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtParameter;

public final class DartParameterDefinitionSpecifier implements ParameterDefinitionSpecifier {

    private final @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier;

    public DartParameterDefinitionSpecifier(@NonNull DartTypeReferenceSpecifier typeReferenceSpecifier) {
        this.typeReferenceSpecifier = typeReferenceSpecifier;
    }

    public @NonNull String specify(CtParameter<?> parameter) {
        return typeReferenceSpecifier.specify(parameter.getType()) + " " + parameter.getSimpleName();
    }
}
