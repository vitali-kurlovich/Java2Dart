package org.java2dart.factory;

import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;

public final class Factory {
    private static final ASTTypeDescriptionFactory _typeDescription = new ASTTypeDescriptionFactory();
    public static ASTTypeDescriptionFactory TypeDescription() {
       return _typeDescription;
    }
}
