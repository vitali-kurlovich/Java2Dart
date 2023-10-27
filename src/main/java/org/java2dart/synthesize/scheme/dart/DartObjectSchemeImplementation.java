package org.java2dart.synthesize.scheme.dart;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.definition.dart.DartMethodDefinitionSpecifier;
import org.java2dart.synthesize.definition.dart.DartVariableDefinitionSpecifier;
import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.impl.dart.DartMethodImplementation;
import org.java2dart.synthesize.impl.method.MethodImplementation;
import org.java2dart.synthesize.impl.varible.VariableImplementation;
import org.java2dart.synthesize.impl.dart.DartVariableImplementation;
import org.java2dart.synthesize.scheme.BaseObjectSchemeImplementation;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtType;

public class DartObjectSchemeImplementation extends BaseObjectSchemeImplementation {
    private final VariableImplementation variableImplementation;
    private final MethodImplementation methodImplementation;
    private final ObjectSchemeSpecifier objectSchemeSpecifier;

    public DartObjectSchemeImplementation(TypeSpecifier typeSpecifier) {
        super(typeSpecifier);

        final var modifiersSpecifier = new DartModifiersSpecifier();
        final var variableImplementation = new DartVariableImplementation(modifiersSpecifier, typeSpecifier);


        this.variableImplementation = new DartVariableImplementation(modifiersSpecifier, typeSpecifier);

        final var variableDefinitionSpecifier = new DartVariableDefinitionSpecifier(typeSpecifier);
        final var methodDefinitionSpecifier = new DartMethodDefinitionSpecifier(modifiersSpecifier, typeSpecifier, variableDefinitionSpecifier);


        this.methodImplementation = new DartMethodImplementation(methodDefinitionSpecifier);
        this.objectSchemeSpecifier = new DartObjectSchemeSpecifier(typeSpecifier, modifiersSpecifier);
        
    }

    @Override
    public @NonNull String implementation(CtType<?> type) {

        final var builder = new StringBuilder();
        builder.append(objectSchemeSpecifier.specify(type));

        builder.append(" {\n");
/*
        for (final var field : schema.getFields()) {

            final var implVar = variableImplementation.variable(field);

            builder.append(implVar);
            builder.append(";\n");

        }

        for (final var method : schema.getMethods()) {
            final var implMethod = methodImplementation.method(method);
            builder.append(implMethod);
        }
*/

        builder.append("}");

        return builder.toString();
    }


}


