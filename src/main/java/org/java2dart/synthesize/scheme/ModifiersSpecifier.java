package org.java2dart.synthesize.scheme;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;


public interface ModifiersSpecifier {
    @NonNull String specify(Set<ModifierKind> modifires);
}
