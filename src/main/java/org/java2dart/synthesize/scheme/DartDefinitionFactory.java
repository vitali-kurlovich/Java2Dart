package org.java2dart.synthesize.scheme;

import org.java2dart.synthesize.definition.dart.*;
import org.java2dart.synthesize.definition.scheme.TypeDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.FieldDefinitionSpecifier;
import org.jspecify.annotations.NonNull;

public class DartDefinitionFactory implements DefinitionFactory {

    private final @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier = new DartTypeReferenceSpecifier();

    private final @NonNull DartModifiersDefinitionSpecifier modifiersDefinitionSpecifier = new DartModifiersDefinitionSpecifier();

    private final  @NonNull DartVariableDefinitionSpecifier variableDefinitionSpecifier = new DartVariableDefinitionSpecifier(this.typeReferenceSpecifier);

    private  final @NonNull DartParameterDefinitionSpecifier parameterDefinitionSpecifier = new DartParameterDefinitionSpecifier(this.typeReferenceSpecifier);

    private final @NonNull DartMethodDefinitionSpecifier methodDefinitionSpecifier = new DartMethodDefinitionSpecifier(this.modifiersDefinitionSpecifier,
            this.typeReferenceSpecifier,
            this.parameterDefinitionSpecifier);

    private final @NonNull DartFieldDefinitionSpecifier fieldDefinitionSpecifier = new DartFieldDefinitionSpecifier(this.modifiersDefinitionSpecifier, this.typeReferenceSpecifier);

    private final @NonNull DartTypeDefinitionSpecifier typeDefinitionSpecifier = new DartTypeDefinitionSpecifier(this.modifiersDefinitionSpecifier, this.typeReferenceSpecifier);

    @Override
    public @NonNull DartTypeReferenceSpecifier typeReferenceSpecifier() {
        return typeReferenceSpecifier;
    }

    @Override
    public @NonNull DartModifiersDefinitionSpecifier modifiersDefinitionSpecifier() {
        return modifiersDefinitionSpecifier;
    }

    @Override
    public @NonNull DartVariableDefinitionSpecifier variableDefinitionSpecifier() {
        return variableDefinitionSpecifier;
    }

    @Override
    public @NonNull DartFieldDefinitionSpecifier fieldDefinitionSpecifier() {
        return fieldDefinitionSpecifier;
    }

    @Override
    public @NonNull DartParameterDefinitionSpecifier parameterDefinitionSpecifier() {
        return parameterDefinitionSpecifier;
    }

    @Override
    public @NonNull DartMethodDefinitionSpecifier methodDefinitionSpecifier() {
        return methodDefinitionSpecifier;
    }

    @Override
    public @NonNull DartTypeDefinitionSpecifier typeDefinitionSpecifier() {
        return typeDefinitionSpecifier;
    }

}
