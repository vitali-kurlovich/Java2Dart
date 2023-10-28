package org.java2dart.synthesize.impl.dart;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.impl.method.MethodImplementation;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.CtMethod;

public final class DartMethodImplementation implements MethodImplementation {
    private final MethodDefinitionSpecifier methodDefinitionSpecifier;

    public DartMethodImplementation(@NonNull MethodDefinitionSpecifier methodDefinitionSpecifier) {
        this.methodDefinitionSpecifier = methodDefinitionSpecifier;
    }

    @Override
    public @NonNull String method(@NonNull CtMethod<?> method) {
        final var modifiersSchema = new ModifiersSchema(method.getModifiers());
        if (modifiersSchema.isAbstract()) {
            return methodDefinitionSpecifier.specify(method) + ";\n";
        }

        return methodDefinitionSpecifier.specify(method) + " {\n" + "}\n";
    }
}
