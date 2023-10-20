package org.java2dart.types.object;

import org.jspecify.annotations.NonNull;


public class InterfaceTypeDescription extends ObjectTypeDescription {
    public InterfaceTypeDescription(@NonNull String typeName, @NonNull boolean nullable) {
        super(typeName, NonPrimitiveType.INTERFACE, nullable);
    }

    @Override
    public TypeKind getTypeKing() {
        return TypeKind.INTERFACE;
    }


}
