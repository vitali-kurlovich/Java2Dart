package org.java2dart.factory.schema.ast;

import org.java2dart.factory.schema.param.ast.ASTTypeParameterFactory;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.ClassSchema;
import org.java2dart.factory.schema.SchemaFactory;
import org.java2dart.schema.IObjectScheme;
import org.java2dart.schema.builder.ObjectSchemaBuilder;
import org.java2dart.schema.builder.ast.ASTObjectSchemaBuilder;
import org.java2dart.types.NamedTypeDescription;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtTypeParameter;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ASTSchemaFactory extends SchemaFactory {

    private final ASTTypeDescriptionFactory typeDescriptionFactory;

    public ASTSchemaFactory(ASTTypeDescriptionFactory typeDescriptionFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
    }

    public IObjectScheme classSchema(CtClass<?> ctClass) throws IllegalStateException {

        final var builder = new ASTObjectSchemaBuilder(typeDescriptionFactory);

        builder.setSpecification(ctClass.getTypeErasure());
        builder.setSuperClass(ctClass.getSuperclass());

        for (final var ref : ctClass.getSuperInterfaces()) {
            builder.appendInterface(ref);
        }

        if (ctClass.isParameterized()) {
            for (final var ref : ctClass.getFormalCtTypeParameters()) {
                builder.appendFormalParameter(ref);
            }
        }
        return builder.build();
    }


    private NamedTypeDescription description(@Nullable CtTypeReference<?> ctTypeReference) throws IllegalStateException {
        if (ctTypeReference == null) {
            return null;
        }
        return (NamedTypeDescription) typeDescriptionFactory.description(ctTypeReference);
    }

    private @NonNull List<TypeDescription> descriptions(List<CtTypeParameter> parameters) throws IllegalStateException {
        final var params = new ArrayList<TypeDescription>();

        for (final var param : parameters) {
            final var ref = param.getReference();
            params.add(description(ref));
        }

        return params;
    }
}
