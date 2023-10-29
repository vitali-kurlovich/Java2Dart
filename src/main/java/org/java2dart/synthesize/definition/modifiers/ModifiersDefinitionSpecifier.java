package org.java2dart.synthesize.definition.modifiers;

import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtModifiable;


public interface ModifiersDefinitionSpecifier {
    @NonNull String specify(CtModifiable modifiable);
}
