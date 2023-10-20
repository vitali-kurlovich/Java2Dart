package org.java2dart.types.object;

import org.jspecify.annotations.NonNull;

public class ClassTypeDescription extends ObjectTypeDescription {
    public ClassTypeDescription(@NonNull String typeName, @NonNull boolean nullable) {
        super(typeName, NonPrimitiveType.CLASS, nullable);
    }

    @Override
    public TypeKind getTypeKing() {
        return TypeKind.CLASS;
    }
}
