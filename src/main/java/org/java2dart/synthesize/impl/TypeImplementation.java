package org.java2dart.synthesize.impl;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;

public interface TypeImplementation {
    @NonNull String source(CtType<?> type);
}
