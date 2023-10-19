package org.java2dart.factory;

import org.java2dart.factory.schema.param.ast.ASTTypeParameterFactory;
import org.java2dart.factory.synthesize.SpecifierFactory;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.factory.schema.ast.ASTSchemaFactory;

public final class Factory {
    private static final ASTTypeDescriptionFactory _typeDescription = new ASTTypeDescriptionFactory();
    private static final ASTTypeParameterFactory _typeParameterFactory = new ASTTypeParameterFactory(TypeDescription());
    private static final ASTSchemaFactory _schemaFactory = new ASTSchemaFactory(TypeDescription(), TypeParameter());

    private static final SpecifierFactory _specifierFactory = new SpecifierFactory();

    public static ASTTypeDescriptionFactory TypeDescription() {
        return _typeDescription;
    }

    public static ASTTypeParameterFactory TypeParameter() {
        return _typeParameterFactory;
    }
    public static ASTSchemaFactory Schema() {
        return _schemaFactory;
    }

    public static SpecifierFactory Specifier() {
        return _specifierFactory;
    }


}
