package org.java2dart.synthesize.definition.scheme;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;


public interface SchemeDefinitionSpecifier {
    @NonNull String specify(CtType<?> type);
}
