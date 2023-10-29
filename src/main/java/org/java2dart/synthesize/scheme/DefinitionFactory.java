package org.java2dart.synthesize.scheme;


import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.definition.modifiers.ModifiersDefinitionSpecifier;
import org.java2dart.synthesize.definition.scheme.TypeDefinitionSpecifier;
import org.java2dart.synthesize.definition.type.TypeReferenceSpecifier;
import org.java2dart.synthesize.definition.varible.FieldDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.ParameterDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.VariableDefinitionSpecifier;
import org.jspecify.annotations.NonNull;


public interface DefinitionFactory {

    @NonNull ModifiersDefinitionSpecifier modifiersDefinitionSpecifier();

    @NonNull TypeReferenceSpecifier typeReferenceSpecifier();

    @NonNull VariableDefinitionSpecifier variableDefinitionSpecifier();


    @NonNull FieldDefinitionSpecifier fieldDefinitionSpecifier();

    @NonNull ParameterDefinitionSpecifier parameterDefinitionSpecifier();

    @NonNull MethodDefinitionSpecifier methodDefinitionSpecifier();

    @NonNull TypeDefinitionSpecifier typeDefinitionSpecifier();

}
