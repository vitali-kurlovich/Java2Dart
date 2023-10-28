package org.java2dart.synthesize.definition.dart;


import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.VariableDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtMethod;

public final class DartMethodDefinitionSpecifier implements MethodDefinitionSpecifier {

    protected final @NonNull ModifiersSpecifier modifiersSpecifier;
    protected final @NonNull TypeSpecifier typeSpecifier;
    protected final @NonNull VariableDefinitionSpecifier variableSpecifier;
    public DartMethodDefinitionSpecifier(@NonNull ModifiersSpecifier modifiersSpecifier,
                                         @NonNull TypeSpecifier typeSpecifier,
                                         @NonNull VariableDefinitionSpecifier variableSpecifier) {
        this.modifiersSpecifier = modifiersSpecifier;
        this.typeSpecifier = typeSpecifier;
        this.variableSpecifier = variableSpecifier;
    }

    @Override
    public @NonNull String specify(CtMethod<?> method) {
        final var builder = new StringBuilder();



      final var returnType =  typeSpecifier.specify( method.getType());


        builder.append(modifiersSpecifier.specify(method.getModifiers()))
                .append(" ")
                .append(returnType)
                .append(" ")
                .append(method.getSimpleName())
                .append("(")
                .append(")");

        return builder.toString();
    }




}
