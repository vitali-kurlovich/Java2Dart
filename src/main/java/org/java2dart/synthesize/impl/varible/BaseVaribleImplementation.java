package org.java2dart.synthesize.impl.varible;

import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;

public abstract class BaseVaribleImplementation implements VaribleImplementation {
    protected final BaseTypeSpecifier typeSpecifier;
    protected final ModifiersSpecifier modifiersSpecifier;

    public BaseVaribleImplementation(ModifiersSpecifier modifiersSpecifier, BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }
}
