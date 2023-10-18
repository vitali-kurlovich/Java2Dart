package org.java2dart.types.object;

import org.java2dart.types.BaseTypeDescription;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;


public abstract class ObjectTypeDescription extends BaseTypeDescription {

    public enum NonPrimitiveType {
        ENUM,
        CLASS,
        INTERFACE
    }

    @NonNull private final String typeName;

    @NonNull
    public final NonPrimitiveType type;

    @NonNull private final boolean nullable;

    protected ObjectTypeDescription( @NonNull String typeName,  @NonNull NonPrimitiveType type, @NonNull boolean nullable) {
        assert (!typeName.isEmpty());

        this.typeName = typeName;
        this.type = type;
        this.nullable = nullable;
    }

    @NonNull public String getTypeName() {
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
}
