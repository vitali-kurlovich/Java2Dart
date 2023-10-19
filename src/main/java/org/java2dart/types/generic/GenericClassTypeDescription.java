package org.java2dart.types.generic;

import org.jspecify.annotations.NonNull;


public class GenericClassTypeDescription extends GenericTypeDescription {

    public GenericClassTypeDescription(@NonNull String typeName) {
        super(typeName);
    }

    @Override
    public TypeKind king() {
        return TypeKind.CLASS;
    }
}
