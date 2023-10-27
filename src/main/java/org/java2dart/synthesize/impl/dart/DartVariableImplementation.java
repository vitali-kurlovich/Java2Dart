package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.impl.varible.VariableImplementation;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtVariable;


public final class DartVariableImplementation   implements VariableImplementation {

    private final TypeSpecifier typeSpecifier;
    private final ModifiersSpecifier modifiersSpecifier;

    public DartVariableImplementation(ModifiersSpecifier modifiersSpecifier, TypeSpecifier typeSpecifier) {
       this.typeSpecifier = typeSpecifier;
       this.modifiersSpecifier = modifiersSpecifier;
    }


    @Override
    public @NonNull String variable(@NonNull CtVariable<?> variable) {
        return typeSpecifier.specify(variable.getType()) + " " + variable.getSimpleName();
    }
}
