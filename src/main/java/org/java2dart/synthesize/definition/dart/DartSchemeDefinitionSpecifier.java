package org.java2dart.synthesize.definition.dart;

import org.java2dart.synthesize.definition.scheme.SchemeDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class DartSchemeDefinitionSpecifier implements SchemeDefinitionSpecifier {

    private final @NonNull ObjectSchemeSpecifier schemeSpecifier;
    private final @NonNull ModifiersSpecifier modifiersSpecifier;
    public DartSchemeDefinitionSpecifier(@NonNull ObjectSchemeSpecifier schemeSpecifier,
                                         @NonNull ModifiersSpecifier modifiersSpecifier) {
        this.schemeSpecifier = schemeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
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


