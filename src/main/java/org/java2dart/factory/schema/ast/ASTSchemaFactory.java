package org.java2dart.factory.schema.ast;

import org.java2dart.factory.schema.param.ast.ASTTypeParameterFactory;
import org.java2dart.factory.types.ast.ASTTypeDescriptionFactory;
import org.java2dart.schema.ClassSchema;
import org.java2dart.factory.schema.SchemaFactory;
import org.java2dart.types.NamedTypeDescription;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtTypeParameter;
import spoon.reflect.reference.CtTypeReference;

import java.util.ArrayList;
import java.util.List;

public class ASTSchemaFactory extends SchemaFactory {

    private final ASTTypeDescriptionFactory typeDescriptionFactory;
   private final ASTTypeParameterFactory typeParameterFactory;

    public ASTSchemaFactory(ASTTypeDescriptionFactory typeDescriptionFactory, ASTTypeParameterFactory typeParameterFactory) {
        this.typeDescriptionFactory = typeDescriptionFactory;
        this.typeParameterFactory =  typeParameterFactory;
    }

    public ClassSchema classSchema(CtClass<?> ctClass) throws IllegalStateException {

       final var type = ctClass.getTypeErasure();
       final var superClass = ctClass.getSuperclass();

       final var description  = description(type);
       assert ( description != null);
// ctClass.getNestedTypes()  internals

       final var superInterfaces =  ctClass.getSuperInterfaces();

       if (  superInterfaces != null) {

       }


       if (ctClass.isParameterized() ) {
          final var params = ctClass.getFormalCtTypeParameters();

          final var formalParameters = typeParameterFactory.typeParameters(params);
           return classSchema(description, formalParameters, description(superClass), null );
       }




       return classSchema(description, description(superClass), null );
    }


    private  NamedTypeDescription description(@Nullable CtTypeReference<?> ctTypeReference) throws IllegalStateException {
        if (ctTypeReference == null) {
            return null;
        }
       return (NamedTypeDescription) typeDescriptionFactory.description(ctTypeReference);
    }

    private @NonNull List<TypeDescription> descriptions(List<CtTypeParameter> parameters) throws IllegalStateException {
        final var params = new ArrayList<TypeDescription>();

        for (final var param: parameters) {
           final var ref = param.getReference();
            params.add(description(ref))  ;
        }

        return params;
    }
}
