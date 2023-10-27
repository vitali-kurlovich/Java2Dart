package org.java2dart.synthesize.impl.varible;

import org.java2dart.schema.varible.IVariable;
import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.synthesize.type.TypeSpecifier;
import org.jspecify.annotations.NonNull;

public abstract class BaseVaribleImplementation implements VariableImplementation {
    protected final TypeSpecifier typeSpecifier;

    protected final ModifiersSpecifier modifiersSpecifier;
    public BaseVaribleImplementation(ModifiersSpecifier modifiersSpecifier, TypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }

    public @NonNull String variable(@NonNull IVariable variable) {

        return  variable( variable.getName(), variable.getType() );

    }
}
