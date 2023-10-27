package org.java2dart.synthesize.definition.method;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtMethod;


public interface MethodDefinitionSpecifier {
    @NonNull String specify(CtMethod<?> method);
}
