package org.java2dart.types.generic;

import org.jspecify.annotations.NonNull;

public class GenericParameterTypeDescription extends GenericTypeDescription {

    public GenericParameterTypeDescription(@NonNull String typeName) {
        super(typeName);
    }

    @Override
    public TypeKind getTypeKing() {
        return TypeKind.GENERIC;
    }
}
