package org.java2dart.synthesize.impl.varible;

import org.java2dart.schema.varible.IVariable;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.jspecify.annotations.NonNull;

public abstract class BaseVaribleImplementation implements VariableImplementation {
    protected final BaseTypeSpecifier typeSpecifier;
    protected final ModifiersSpecifier modifiersSpecifier;

    public BaseVaribleImplementation(ModifiersSpecifier modifiersSpecifier, BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }

    public @NonNull String variable(@NonNull IVariable variable) {

        return  variable(variable.getModifiers(), variable.getName(), variable.getType() );

    }
}
