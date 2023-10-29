package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.varible.ParameterDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.VariableDefinitionSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;

public final class DartVariableDefinitionSpecifier
        implements VariableDefinitionSpecifier,
        ParameterDefinitionSpecifier {

    private final TypeSpecifier typeSpecifier;

    public DartVariableDefinitionSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }

    @Override
    public @NonNull String specify(CtVariable<?> variable) {
        return typeSpecifier.specify(variable.getType()) + "  " + variable.getSimpleName();
    }

    public @NonNull String specify(CtParameter<?> parameter) {
        return typeSpecifier.specify(parameter.getType()) + " _ " + parameter.getSimpleName();
    }
}
