package org.java2dart.types.generic;

import org.jspecify.annotations.NonNull;

public class GenericInterfaceTypeDescription extends GenericTypeDescription {

    public GenericInterfaceTypeDescription(@NonNull String typeName) {
        super(typeName);
    }

    @Override
    public TypeKind king() {
        return TypeKind.CLASS;
    }
}
