package org.java2dart.synthesize.definition.method;

import org.java2dart.schema.method.IMethod;
import org.java2dart.schema.method.Method;
import org.java2dart.schema.method.Parameter;
import org.java2dart.synthesize.definition.dart.DartSchemeDefinitionSpecifier;
import org.java2dart.synthesize.definition.varible.VariableDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.List;
import java.util.Set;


public abstract class BaseMethodDefinitionSpecifier implements MethodDefinitionSpecifier {

    protected final @NonNull ModifiersSpecifier modifiersSpecifier;

    protected final @NonNull BaseTypeSpecifier typeSpecifier;
    protected final @NonNull VariableDefinitionSpecifier variableSpecifier;

    public BaseMethodDefinitionSpecifier(@NonNull ModifiersSpecifier modifiersSpecifier,
                                         @NonNull BaseTypeSpecifier typeSpecifier,
                                         @NonNull VariableDefinitionSpecifier variableSpecifier) {
        this.modifiersSpecifier = modifiersSpecifier;
        this.typeSpecifier = typeSpecifier;
        this.variableSpecifier = variableSpecifier;
    }

    @Override
    public @NonNull String specify(IMethod method) {
        return method(method.getModifiers(), method.getName(), method.getReturnType(), method.getArguments());
    }

    public abstract @NonNull String method(@Nullable Set<ModifierKind> modifiers,
                                  @NonNull String name,
                                  @NonNull TypeDescription returnType,
                                  @Nullable List<Parameter> arguments);
}
