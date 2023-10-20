package org.java2dart.types;

public interface TypeDescription {

    boolean isVoid() ;
    boolean isPrimitive();

    boolean isNullable() ;

    boolean isArray() ;

    boolean isGeneric() ;

    TypeKind king();

   enum TypeKind {
        ENUM,
        CLASS,
        INTERFACE,
        PRIMITIVE,

       NONE
    }
}


