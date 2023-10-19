package org.java2dart.types.object.parameterized;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;

import java.util.List;

public final class ParameterizedInterfaceTypeDescription extends ParameterizedTypeDescription {
    public ParameterizedInterfaceTypeDescription(@NonNull String typeName, List<TypeDescription> typeArguments, @NonNull boolean nullable) {
        super(typeName, NonPrimitiveType.INTERFACE, typeArguments, nullable);
    }
}
