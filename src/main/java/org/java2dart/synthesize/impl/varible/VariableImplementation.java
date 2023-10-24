package org.java2dart.synthesize.impl.varible;

import org.java2dart.schema.varible.IVariable;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public interface VariableImplementation {
    @NonNull String variable(@Nullable Set<ModifierKind> modifires, @NonNull String name, @NonNull TypeDescription type);
    @NonNull String variable(@NonNull IVariable variable);
}
