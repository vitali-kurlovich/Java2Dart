package org.java2dart.synthesize.type;

import org.jspecify.annotations.NonNull;
import spoon.reflect.reference.CtTypeReference;


public interface TypeSpecifier {
    @NonNull String specify(CtTypeReference<?> typeReference);
}
