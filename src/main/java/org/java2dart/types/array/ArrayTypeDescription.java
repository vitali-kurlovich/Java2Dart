package org.java2dart.types.array;

import org.java2dart.types.BaseTypeDescription;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;

public class ArrayTypeDescription extends BaseTypeDescription {
    @NonNull
    private final boolean nullable;
    @NonNull
    public TypeDescription baseType;

    public ArrayTypeDescription(@NonNull TypeDescription baseType, @NonNull boolean nullable) {
        this.baseType = baseType;
        this.nullable = nullable;
    }

    @Override
    public boolean isVoid() {
        return false;
    }

    @Override
    public boolean isPrimitive() {
        return false;
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    @Override
    public boolean isArray() {
        return true;
    }

    @Override
    public boolean isGeneric() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + "baseType: > -----------------\n" +
                baseType.toString()
                + "< -----------------\n";

    }

    @Override
    public TypeKind king() {
        return baseType.king();
    }
}
