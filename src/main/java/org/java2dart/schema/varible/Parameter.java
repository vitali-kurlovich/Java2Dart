package org.java2dart.schema.varible;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;
import spoon.reflect.declaration.ModifierKind;

import java.util.Set;

public class Parameter extends BaseVarible {
    public Parameter(@NonNull String name, @NonNull TypeDescription type, Set<ModifierKind> modifiers) {
        super(name, type, modifiers);
    }

    public boolean isVarArgs() {
        return true;
    }
}
