package org.java2dart.synthesize.impl.method;

import org.java2dart.schema.method.Method;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;


public abstract class BaseMethodImplementation implements MethodImplementation {
    protected final BaseTypeSpecifier typeSpecifier;
    protected final ModifiersSpecifier modifiersSpecifier;

    public BaseMethodImplementation(ModifiersSpecifier modifiersSpecifier, BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }


    @Override
    public @NonNull String method( @NonNull Method method) {

        return method(method.getModifiers(), method.getName(), method.getReturnType(), method.getArguments());
    }
}
