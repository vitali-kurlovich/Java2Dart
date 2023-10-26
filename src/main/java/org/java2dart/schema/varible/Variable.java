package org.java2dart.schema.varible;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;


public class Variable implements IVariable {
    @NonNull
    private final String name;
    @NonNull
    private final TypeDescription type;


    public Variable(@NonNull String name, @NonNull TypeDescription type) {
        this.name = name;
        this.type = type;

    }

    @Override
    public @NonNull String getName() {
        return name;
    }

    @Override
    public @NonNull TypeDescription getType() {
        return type;
    }
}
