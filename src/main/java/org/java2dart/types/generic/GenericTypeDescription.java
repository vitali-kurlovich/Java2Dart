package org.java2dart.types.generic;

import org.java2dart.types.BaseTypeDescription;
import org.java2dart.types.NamedTypeDescription;
import org.java2dart.types.object.ObjectTypeDescription;
import org.jspecify.annotations.NonNull;

public class GenericTypeDescription extends BaseTypeDescription implements NamedTypeDescription {

    @NonNull
    private final String typeName;

    public GenericTypeDescription(@NonNull String typeName) {
        assert (!typeName.isEmpty());
        this.typeName = typeName;
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
        return false;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    @Override
    public boolean isGeneric() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString()


                + "typeName: " + getTypeName() + "\n";
    }

}
