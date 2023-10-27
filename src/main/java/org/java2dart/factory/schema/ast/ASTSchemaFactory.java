package org.java2dart.factory.schema.ast;

import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.IObjectScheme;
import org.java2dart.schema.builder.ast.ASTObjectSchemaBuilder;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;


public class ASTSchemaFactory {
    private final ASTTypeDescriptionFactory typeDescriptionFactory;
    private final ASTSchemaFieldFactory fieldsFactory;
    private final ASTSchemaMethodFactory methodFactory;

   // private final IExecutableBuilder executableBuilder;

    public ASTSchemaFactory(@NonNull ASTTypeDescriptionFactory typeDescriptionFactory,
                            @NonNull ASTSchemaFieldFactory fieldsFactory,
                            @NonNull ASTSchemaMethodFactory methodFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
      this.fieldsFactory = fieldsFactory;
      this.methodFactory = methodFactory;

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



}
