package org.java2dart.synthesize.impl.method;

import org.java2dart.schema.method.Method;
import org.java2dart.schema.varible.Parameter;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.List;
import java.util.Set;

public interface MethodImplementation {
    @NonNull String method(@Nullable Set<ModifierKind> modifiers,
                           @NonNull String name,
                           @NonNull TypeDescription returnType,
                           @Nullable List<Parameter> arguments);
    @NonNull String method( @NonNull Method method);
}
