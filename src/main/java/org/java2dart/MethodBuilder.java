package org.java2dart;

import org.java2dart.types.TypeDescription;
import org.jspecify.annotations.NonNull;


public class MethodBuilder {





    void append(@NonNull TypeDescription returnType, @NonNull String name ) {

    }

    private final StringBuilder builder = new StringBuilder();

    void append( @NonNull String string) {
        builder.append(string);
    }

    void dd() {
        append(null);
    }
}
