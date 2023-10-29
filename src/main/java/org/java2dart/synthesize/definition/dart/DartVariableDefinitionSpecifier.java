package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.varible.VariableDefinitionSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtVariable;

public final class DartVariableDefinitionSpecifier
        implements VariableDefinitionSpecifier {

    private final @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier;

    public DartVariableDefinitionSpecifier(@NonNull DartTypeReferenceSpecifier typeReferenceSpecifier) {
        this.typeReferenceSpecifier = typeReferenceSpecifier;
    }

    @Override
    public @NonNull String specify(CtVariable<?> variable) {
        return typeReferenceSpecifier.specify(variable.getType()) + "  " + variable.getSimpleName();
    }

}
