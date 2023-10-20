package org.java2dart.types.object.parameterized;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;

import java.util.List;

public final class ParameterizedClassTypeDescription extends ParameterizedTypeDescription {
    public ParameterizedClassTypeDescription(@NonNull String typeName,
                                             List<TypeDescription> typeArguments,
                                             @NonNull boolean nullable) {
        super(typeName, NonPrimitiveType.CLASS, typeArguments, nullable);
    }

    @Override
    public TypeKind getTypeKing() {
        return TypeKind.CLASS;
    }
}
