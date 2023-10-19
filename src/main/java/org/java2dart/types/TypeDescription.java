package org.java2dart.types;

import org.jspecify.annotations.NonNull;

public interface TypeDescription {

    boolean isVoid() ;
    boolean isPrimitive();

    boolean isNullable() ;

    boolean isArray() ;

    boolean isGeneric() ;
}


