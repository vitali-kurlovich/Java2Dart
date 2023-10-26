package org.java2dart.synthesize.impl.dart;

import org.java2dart.schema.base.ModifiersSchema;
import org.java2dart.schema.method.IMethod;
import org.java2dart.synthesize.definition.method.MethodDefinitionSpecifier;
import org.java2dart.synthesize.impl.method.BaseMethodImplementation;
import org.jspecify.annotations.NonNull;

public class DartMethodImplementation extends BaseMethodImplementation {

    public DartMethodImplementation(MethodDefinitionSpecifier methodDefinitionSpecifier) {
        super(methodDefinitionSpecifier);
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
