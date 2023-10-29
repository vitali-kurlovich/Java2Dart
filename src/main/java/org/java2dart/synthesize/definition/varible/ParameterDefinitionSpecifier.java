package org.java2dart.synthesize.definition.varible;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtParameter;

public interface ParameterDefinitionSpecifier {
    @NonNull String specify(CtParameter<?> parameter);
}
