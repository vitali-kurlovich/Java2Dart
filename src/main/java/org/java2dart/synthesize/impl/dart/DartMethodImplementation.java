package org.java2dart.synthesize.impl.dart;

import org.java2dart.schema.varible.Parameter;
import org.java2dart.synthesize.impl.method.BaseMethodImplementation;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.List;
import java.util.Set;

public class DartMethodImplementation extends BaseMethodImplementation {

    public DartMethodImplementation(ModifiersSpecifier modifiersSpecifier, BaseTypeSpecifier typeSpecifier) {
        super(modifiersSpecifier, typeSpecifier);
    }

    @Override
    public @NonNull String method(@Nullable Set<ModifierKind> modifiers,
                                  @NonNull String name,
                                  @NonNull TypeDescription returnType,
                                  @Nullable List<Parameter> arguments) {

        final var returnTypeDsc =  typeSpecifier.specify(returnType);
        return modifiersSpecifier.specify(modifiers)  + returnTypeDsc + " " + name + "(" + ")";

    }
}
