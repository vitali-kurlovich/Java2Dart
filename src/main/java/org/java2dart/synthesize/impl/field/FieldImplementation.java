package org.java2dart.synthesize.impl.field;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtMethod;


public interface FieldImplementation {

    @NonNull String source(CtField<?> field);

}
