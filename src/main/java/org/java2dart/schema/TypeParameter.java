package org.java2dart.schema;

import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Set;

public class TypeParameter extends ObjectScheme {


    public TypeParameter(NamedTypeDescription specification, @Nullable NamedTypeDescription superClass, @Nullable Set<NamedTypeDescription> interfaces) {
        super(specification, superClass, interfaces);
    }

    public TypeParameter(@NonNull NamedTypeDescription specification, @Nullable NamedTypeDescription superClass) {
        super(specification, superClass);
    }

    public TypeParameter(@NonNull NamedTypeDescription specification, @Nullable Set<NamedTypeDescription> interfaces) {
        super(specification, interfaces);
    }

    public TypeParameter(@NonNull NamedTypeDescription specification) {
        super(specification);
    }
}
