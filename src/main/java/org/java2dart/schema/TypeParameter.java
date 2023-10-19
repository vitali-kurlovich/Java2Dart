package org.java2dart.schema;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class TypeParameter {
    private final @NonNull TypeDescription typeDescription;
    private final @Nullable List<TypeDescription> interfaces;

    public TypeParameter(@NonNull TypeDescription typeDescription, @Nullable List<TypeDescription> interfaces) {
        this.typeDescription = typeDescription;
        this.interfaces = interfaces;
    }

    public TypeParameter(@NonNull TypeDescription typeDescription) {

        this(typeDescription, null);
    }
}
