package org.java2dart.types;

public interface TypeDescription {

    boolean isVoid();

    boolean isPrimitive();

    boolean isNullable();

    boolean isArray();

    boolean isGeneric();

    TypeKind getTypeKing();

    enum TypeKind {
        ENUM,
        CLASS,
        INTERFACE,
        GENERIC,
        PRIMITIVE,
        NONE,

    }
}


