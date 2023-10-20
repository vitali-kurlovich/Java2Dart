package org.java2dart.types.none;

import org.java2dart.types.BaseTypeDescription;

public final class VoidTypeDescription extends BaseTypeDescription {

    public static VoidTypeDescription VOID = new VoidTypeDescription();

    private VoidTypeDescription() {
    }

    @Override
    public boolean isVoid() {
        return true;
    }

    @Override
    public boolean isPrimitive() {
        return true;
    }

    @Override
    public boolean isNullable() {
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isGeneric() {
        return false;
    }

    @Override
    public TypeKind getTypeKing() {
        return TypeKind.NONE;
    }
}
