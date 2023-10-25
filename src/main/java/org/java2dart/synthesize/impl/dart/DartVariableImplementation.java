package org.java2dart.synthesize.impl.dart;

import org.java2dart.synthesize.impl.varible.BaseVaribleImplementation;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;


public final class DartVariableImplementation extends BaseVaribleImplementation {

    public DartVariableImplementation(ModifiersSpecifier modifiersSpecifier, BaseTypeSpecifier typeSpecifier) {
        super(modifiersSpecifier, typeSpecifier);
    }

    @Override
    public @NonNull String variable( @NonNull String name, @NonNull TypeDescription type) {
        final var typeDsc = typeSpecifier.specify(type);
        return   typeDsc + " " + name;
    }

}
