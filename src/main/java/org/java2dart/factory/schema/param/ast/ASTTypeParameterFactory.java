package org.java2dart.factory.schema.param.ast;

import org.java2dart.factory.schema.param.TypeParameterFactory;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.TypeParameter;
import org.java2dart.types.NamedTypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtTypeParameter;

import java.util.ArrayList;
import java.util.List;

public class ASTTypeParameterFactory extends TypeParameterFactory {

    private final ASTTypeDescriptionFactory typeDescriptionFactory;

    public ASTTypeParameterFactory(ASTTypeDescriptionFactory typeDescriptionFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
    }

    public @NonNull TypeParameter typeParameter(@NonNull CtTypeParameter parameter) {

        throw new RuntimeException("Not implemented");

    }
}
