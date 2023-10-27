package org.java2dart.synthesize.scheme;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;


public interface ObjectSchemeSpecifier {
    @NonNull String specify(CtType<?> type);
}

