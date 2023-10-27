package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.varible.VariableDefinitionSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtVariable;

public class DartVariableDefinitionSpecifier implements VariableDefinitionSpecifier {

    private final TypeSpecifier typeSpecifier;
    public DartVariableDefinitionSpecifier(TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }


    @Override
    public @NonNull String specify(CtVariable<?> variable) {

        //variable.isFinal()

        return variable.getSimpleName();
    }
}
