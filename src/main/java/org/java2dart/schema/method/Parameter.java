package org.java2dart.schema.method;

import org.java2dart.schema.varible.Variable;
import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;

public class Parameter extends Variable {
    public Parameter(@NonNull String name, @NonNull TypeDescription type) {
        super(name, type);
    }

    public boolean isVarArgs() {
        return true;
    }
}
