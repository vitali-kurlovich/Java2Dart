package org.java2dart.synthesize.impl.method;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.schema.method.IMethod;
import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.jspecify.annotations.NonNull;


public abstract class BaseMethodImplementation implements MethodImplementation {

    protected final MethodDefinitionSpecifier methodDefinitionSpecifier;

    public BaseMethodImplementation(MethodDefinitionSpecifier methodDefinitionSpecifier) {
        this.methodDefinitionSpecifier = methodDefinitionSpecifier;
    }


    @Override
    public @NonNull String method(@NonNull IMethod method) {
        final var modifiersSchema = new ModifiersSchema(method.getModifiers());

        if (modifiersSchema.isAbstract()) {
            return methodDefinitionSpecifier.specify(method) + ";\n";
        }

        return methodDefinitionSpecifier.specify(method) + " {\n" + "}\n";
    }
}
