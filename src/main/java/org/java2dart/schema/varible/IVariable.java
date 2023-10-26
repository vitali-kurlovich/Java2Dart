package org.java2dart.schema.varible;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;

public interface IVariable {
    @NonNull String getName();
    @NonNull TypeDescription getType();
}