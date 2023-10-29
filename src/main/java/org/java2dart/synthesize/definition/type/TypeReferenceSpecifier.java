package org.java2dart.synthesize.definition.type;

import org.jspecify.annotations.NonNull;
import spoon.reflect.reference.CtTypeReference;


public interface TypeReferenceSpecifier {
    @NonNull String specify(CtTypeReference<?> typeReference);
}
