package org.java2dart.schema.method;

import org.java2dart.schema.varible.BaseVariable;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class Parameter extends BaseVariable {
    public Parameter(@NonNull String name, @NonNull TypeDescription type) {
        super(name, type);
    }

    public boolean isVarArgs() {
        return true;
    }
}
