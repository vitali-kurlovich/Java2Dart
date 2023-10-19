package org.java2dart.factory.schema.param;

import org.java2dart.schema.TypeParameter;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Set;

public class TypeParameterFactory {

public @NonNull TypeParameter typeParameter(@NonNull NamedTypeDescription specification,
                                            @Nullable NamedTypeDescription superClass,
                                            @Nullable Set<NamedTypeDescription> interfaces) {
    return new TypeParameter(specification, superClass, interfaces);
}

    public @NonNull TypeParameter typeParameter(@NonNull NamedTypeDescription specification,
                                                @Nullable NamedTypeDescription superClass) {
        return new TypeParameter(specification, superClass);
    }
    public @NonNull TypeParameter typeParameter(@NonNull NamedTypeDescription specification,
                                                @Nullable Set<NamedTypeDescription> interfaces) {
        return new TypeParameter(specification, null, interfaces);
    }

    public @NonNull TypeParameter typeParameter(@NonNull NamedTypeDescription specification) {
        return new TypeParameter(specification);
    }

}
