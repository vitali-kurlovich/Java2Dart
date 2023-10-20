package org.java2dart.types.object;

import org.java2dart.types.BaseTypeDescription;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;

public abstract class ObjectTypeDescription extends BaseTypeDescription implements NamedTypeDescription {

    @NonNull
    public final NonPrimitiveType type;
    @NonNull
    private final String typeName;
    @NonNull
    private final boolean nullable;

    protected ObjectTypeDescription(@NonNull String typeName, @NonNull NonPrimitiveType type, @NonNull boolean nullable) {
        assert (!typeName.isEmpty());

        this.typeName = typeName;
        this.type = type;
        this.nullable = nullable;
    }

    @NonNull
    public String getTypeName() {
        return typeName;
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
        return false;
    }

    @Override
    public boolean isGeneric() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString()
                + "type: " +
                getTypeName() + "\n"
                + "typeName: " + typeName + "\n";
    }

    public enum NonPrimitiveType {
        ENUM,
        CLASS,
        INTERFACE
    }
}
