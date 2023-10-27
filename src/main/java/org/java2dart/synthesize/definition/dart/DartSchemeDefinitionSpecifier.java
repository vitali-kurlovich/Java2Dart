package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.scheme.BaseSchemeDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class DartSchemeDefinitionSpecifier extends BaseSchemeDefinitionSpecifier {
    public DartSchemeDefinitionSpecifier(@NonNull ObjectSchemeSpecifier typeParameterSpecifier,
                                         @NonNull ModifiersSpecifier modifiersSpecifier) {
        super(typeParameterSpecifier, modifiersSpecifier);
    }

    @Override
    public @NonNull String specify(CtType<?> type) {
        return specify(type.getModifiers()) + " " +
               // specify(type.getTypeKing()) + " " +
                schemeSpecifier.specify(type);
    }



    private @NonNull String specify(Set<ModifierKind> modifiers) {
        return modifiersSpecifier.specify(modifiers);
    }


}


