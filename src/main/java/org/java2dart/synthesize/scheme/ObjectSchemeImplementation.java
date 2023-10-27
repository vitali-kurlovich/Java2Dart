package org.java2dart.synthesize.scheme;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;


public interface ObjectSchemeImplementation {
    @NonNull String implementation(CtType<?> type );
}
