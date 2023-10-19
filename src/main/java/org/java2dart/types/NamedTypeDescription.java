package org.java2dart.types;

import org.jspecify.annotations.NonNull;

public interface NamedTypeDescription extends TypeDescription {
    @NonNull String getTypeName();
}
