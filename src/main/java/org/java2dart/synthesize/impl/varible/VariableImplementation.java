package org.java2dart.synthesize.impl.varible;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtVariable;

public interface VariableImplementation {
    @NonNull String variable(@NonNull CtVariable<?> variable);
}
