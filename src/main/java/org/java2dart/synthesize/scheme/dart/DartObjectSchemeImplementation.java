package org.java2dart.synthesize.scheme.dart;

import org.java2dart.schema.IObjectScheme;
import org.java2dart.synthesize.impl.dart.DartMethodImplementation;
import org.java2dart.synthesize.impl.method.MethodImplementation;
import org.java2dart.synthesize.impl.varible.VariableImplementation;
import org.java2dart.synthesize.impl.dart.DartVariableImplementation;
import org.java2dart.synthesize.scheme.BaseObjectSchemeImplementation;
import org.java2dart.synthesize.scheme.ObjectSchemeSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public class DartObjectSchemeImplementation extends BaseObjectSchemeImplementation {

    private final VariableImplementation variableImplementation;
    private final MethodImplementation methodImplementation;

    private final ObjectSchemeSpecifier objectSchemeSpecifier;

    public DartObjectSchemeImplementation(BaseTypeSpecifier typeSpecifier) {
        super(typeSpecifier);

        final var modifiersSpecifier = new DartModifiersSpecifier();
        this.variableImplementation = new DartVariableImplementation(modifiersSpecifier, typeSpecifier);
        this.methodImplementation = new DartMethodImplementation(modifiersSpecifier, typeSpecifier);
        this.objectSchemeSpecifier = new DartObjectSchemeSpecifier(typeSpecifier);

    }

    @Override
    public @NonNull String implementation(IObjectScheme schema) {

        final var builder = new StringBuilder();
        builder.append(objectSchemeSpecifier.specify(schema));

        builder.append(" {\n");

        for (final var field : schema.getFields()) {

            final var implVar = variableImplementation.variable(field);

            builder.append(implVar);
            builder.append(";\n");

        }

        for (final var method : schema.getMethods()) {
            final var implMethod = methodImplementation.method(method);
            builder.append(implMethod);
            builder.append(";\n");
        }


        builder.append("}");

        return builder.toString();
    }


}


