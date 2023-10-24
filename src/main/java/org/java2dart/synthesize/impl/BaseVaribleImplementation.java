package org.java2dart.synthesize.impl;

import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public abstract class BaseVaribleImplementation implements VaribleImplementation {

    protected BaseTypeSpecifier typeSpecifier;

    public BaseVaribleImplementation(BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
    }


}
