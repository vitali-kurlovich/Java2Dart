package org.java2dart.synthesize.definition.varible;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtVariable;


public interface VariableDefinitionSpecifier {
    @NonNull String specify(CtVariable<?> variable);
}
