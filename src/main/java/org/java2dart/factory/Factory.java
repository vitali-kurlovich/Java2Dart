package org.java2dart.factory;

import org.java2dart.expression.builder.ExpressionBuilder;
import org.java2dart.factory.schema.ast.ASTSchemaFactory;
import org.java2dart.factory.synthesize.SpecifierFactory;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.synthesize.scheme.ObjectSchemeImplementation;
import org.java2dart.synthesize.scheme.dart.DartObjectSchemeImplementation;

public final class Factory {

    private static final ASTFactories astFactories = new ASTFactories();


    private static final SpecifierFactory _specifierFactory = new SpecifierFactory();

    private static final ObjectSchemeImplementation _schemeImplementation = new DartObjectSchemeImplementation(Specifier().typeSpecifier());

    public static ASTTypeDescriptionFactory TypeDescription() {
        return astFactories.typeDescriptionFactory;
    }

    public static ASTSchemaFactory Schema() {
        return astFactories.schemaFactory;
    }

    public static SpecifierFactory Specifier() {
        return _specifierFactory;
    }

    public static ObjectSchemeImplementation SchemeImplementation() {
        return _schemeImplementation;
    }

}
