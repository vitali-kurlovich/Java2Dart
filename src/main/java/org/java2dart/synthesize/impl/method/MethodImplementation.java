package org.java2dart.synthesize.impl.method;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtMethod;

public interface MethodImplementation {

    @NonNull String method( @NonNull CtMethod<?> method);
}
