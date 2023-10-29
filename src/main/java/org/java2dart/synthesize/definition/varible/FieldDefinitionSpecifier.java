package org.java2dart.synthesize.definition.varible;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtField;

public interface FieldDefinitionSpecifier {
    @NonNull String specify(CtField<?> field);
}
