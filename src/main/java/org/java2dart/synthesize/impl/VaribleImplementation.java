package org.java2dart.synthesize.impl;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public interface VaribleImplementation {
    @NonNull String varible(@Nullable Set<ModifierKind> modifires, @NonNull String name, @NonNull TypeDescription type);
}
