package org.java2dart.factory.schema.ast;

import org.java2dart.expression.builder.IExpressionBuilder;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.IObjectScheme;
import org.java2dart.schema.builder.ast.ASTObjectSchemaBuilder;
import org.java2dart.types.NamedTypeDescription;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypeParameter;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;


public class ASTSchemaFactory {
    private final ASTTypeDescriptionFactory typeDescriptionFactory;
    private final ASTSchemaFieldFactory fieldsFactory;
    private final ASTSchemaMethodFactory methodFactory;

   // private final IExecutableBuilder executableBuilder;

    public ASTSchemaFactory(@NonNull ASTTypeDescriptionFactory typeDescriptionFactory,
                            @NonNull IExpressionBuilder executableBuilder) {
        this.typeDescriptionFactory = typeDescriptionFactory;
        fieldsFactory = new ASTSchemaFieldFactory(typeDescriptionFactory);
        methodFactory = new ASTSchemaMethodFactory(typeDescriptionFactory, executableBuilder);

    }

    public IObjectScheme schema(CtType<?> ctType) throws IllegalStateException {

        final var builder = new ASTObjectSchemaBuilder(typeDescriptionFactory);

        builder.setSpecification(ctType.getTypeErasure());
        builder.setSuperClass(ctType.getSuperclass());

        for (final var ref : ctType.getSuperInterfaces()) {
            builder.appendInterface(ref);
        }

        builder.setModifiers(ctType.getModifiers());

        if (ctType.isParameterized()) {
            for (final var ref : ctType.getFormalCtTypeParameters()) {
                builder.appendFormalParameter(ref);
            }
        }

        final var fields = fieldsFactory.fields(ctType.getFields());
        builder.setFields(fields);

        final var methods = methodFactory.methods(ctType.getMethods());
        builder.setMethods(methods);

        return builder.build();
    }


    void field(CtField<?> ctField) {

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
