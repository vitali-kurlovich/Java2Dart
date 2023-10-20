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

        final var type = parameter.getReference();
        final var specification = (NamedTypeDescription) typeDescriptionFactory.description(type);
        // TODO: Interfaces

        final var superClass = parameter.getSuperclass();
        if (superClass != null) {
            final var superClassSpec = (NamedTypeDescription) typeDescriptionFactory.description(superClass);
            return typeParameter(specification, superClassSpec);
        }

        return typeParameter(specification);
    }

    public @NonNull List<TypeParameter> typeParameters(@NonNull List<CtTypeParameter> parameters) {

        final var typeParameters = new ArrayList<TypeParameter>();

        for (final var param : parameters) {
            typeParameters.add(typeParameter(param));
        }

        return typeParameters;
    }
}
