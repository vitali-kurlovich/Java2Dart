package org.java2dart.synthesize.scheme.dart;

import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class DartModifiersSpecifier implements ModifiersSpecifier {

    @Override
    public @NonNull String specify(Set<ModifierKind> modifires) {
        final var builder = new StringBuilder();



        return builder.toString();
    }
}
