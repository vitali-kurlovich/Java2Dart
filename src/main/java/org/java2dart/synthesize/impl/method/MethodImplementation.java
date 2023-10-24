package org.java2dart.synthesize.impl.method;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public interface MethodImplementation {
    @NonNull String method(@Nullable Set<ModifierKind> modifires, @NonNull String name, @NonNull TypeDescription returnType);
}
