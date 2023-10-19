package org.java2dart.types.object;

import org.jspecify.annotations.NonNull;

public final class EnumTypeDescription extends ObjectTypeDescription {
    public EnumTypeDescription(@NonNull String typeName, @NonNull boolean nullable) {
        super(typeName, NonPrimitiveType.ENUM, nullable);
    }

    @Override
    public TypeKind king() {
        return TypeKind.ENUM;
    }
}
