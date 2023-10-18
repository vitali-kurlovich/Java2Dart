package org.java2dart.factory;

import org.java2dart.types.TypeDescription;
import org.java2dart.types.factory.ASTTypeDescriptionFactory;
import org.java2dart.types.factory.TypeDescriptionFactory;

public final class Factory {
    private static final ASTTypeDescriptionFactory _typeDescription = new ASTTypeDescriptionFactory();
    public static ASTTypeDescriptionFactory TypeDescription() {
       return _typeDescription;
    }
}
