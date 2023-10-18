package org.java2dart.types.primitive;

import org.java2dart.types.BaseTypeDescription;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class PrimitiveTypeDescription extends BaseTypeDescription {

    public static PrimitiveTypeDescription BYTE = new PrimitiveTypeDescription(PrimitiveType.BYTE);
    public static PrimitiveTypeDescription SHORT = new PrimitiveTypeDescription(PrimitiveType.SHORT);
    public static PrimitiveTypeDescription INT = new PrimitiveTypeDescription(PrimitiveType.INT);
    public static PrimitiveTypeDescription LONG = new PrimitiveTypeDescription(PrimitiveType.LONG);
    public static PrimitiveTypeDescription FLOAT = new PrimitiveTypeDescription(PrimitiveType.FLOAT);
    public static PrimitiveTypeDescription DOUBLE = new PrimitiveTypeDescription(PrimitiveType.DOUBLE);
    public static PrimitiveTypeDescription BOOLEAN = new PrimitiveTypeDescription(PrimitiveType.BOOLEAN);
    public static PrimitiveTypeDescription CHAR = new PrimitiveTypeDescription(PrimitiveType.CHAR);

    private static Map<String, PrimitiveTypeDescription> _map ;
    {
        _map.put("byte", BYTE);
        _map.put("short", SHORT);
        _map.put("int", INT);
        _map.put("long", LONG);
        _map.put("float", FLOAT);
        _map.put("double", DOUBLE);
        _map.put("boolean", BOOLEAN);
        _map.put("char", CHAR);
    }

    public static boolean isPrimitive(@NonNull String name) {
        return  _map.containsKey(name);
    }

    public static @NonNull PrimitiveTypeDescription descriptionByName(@NonNull String name) throws IllegalStateException {
        assert( isPrimitive(name));
        final var desc = _map.get(name);
        if (desc == null) {
            throw new IllegalStateException("Illegal type name: " + name);
        }
        return  desc;
    }


    @NonNull
    public final PrimitiveType type;

    private PrimitiveTypeDescription(@NonNull PrimitiveType type) {
        this.type = type;
    }

    @Override
    public boolean isVoid() {
        return false;
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


}
