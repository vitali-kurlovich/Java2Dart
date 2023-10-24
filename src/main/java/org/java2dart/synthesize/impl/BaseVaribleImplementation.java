package org.java2dart.synthesize.impl;

import org.java2dart.synthesize.scheme.ModifiersSpecifier;
import org.java2dart.synthesize.scheme.dart.DartModifiersSpecifier;
import org.java2dart.synthesize.type.BaseTypeSpecifier;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public abstract class BaseVaribleImplementation implements VaribleImplementation {
    protected final BaseTypeSpecifier typeSpecifier;
    protected final ModifiersSpecifier modifiersSpecifier;

    public BaseVaribleImplementation(ModifiersSpecifier modifiersSpecifier, BaseTypeSpecifier typeSpecifier) {
        this.typeSpecifier = typeSpecifier;
        this.modifiersSpecifier = modifiersSpecifier;
    }
}
